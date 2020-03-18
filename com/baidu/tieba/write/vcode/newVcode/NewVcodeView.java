package com.baidu.tieba.write.vcode.newVcode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.a;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.vcode.newVcode.a.b;
/* loaded from: classes13.dex */
public class NewVcodeView {
    private BaseActivity dYz;
    private b kRz;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View kOv = null;
    private View kOw = null;
    private a kOy = null;
    private TextView kOx = null;
    private d kRD = null;
    private boolean kOz = false;
    private Runnable kOA = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.dYz = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.kRz = bVar;
        this.kOz = false;
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    @JavascriptInterface
    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean initUI(NewVcodeActivity newVcodeActivity) {
        newVcodeActivity.setActivityBgTransparent();
        newVcodeActivity.setSwipeBackEnabled(false);
        newVcodeActivity.setContentView(R.layout.new_vcode_activity);
        this.kOv = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.kOv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.kRz.cUQ();
                NewVcodeView.this.dYz.finish();
            }
        });
        this.kOw = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.kOx = (TextView) this.kOw.findViewById(R.id.custom_loading_text);
        this.kOx.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.kRD = new d();
        this.kRD.toastTime = 1000L;
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) newVcodeActivity.findViewById(R.id.new_vcode_webview);
                UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.mWebView, 1.2631578f);
                this.mWebView.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.mWebView.setInitialScale(100);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str)) {
                            return false;
                        }
                        if (!NewVcodeView.this.kOz) {
                            NewVcodeView.this.kOz = true;
                            e.gx().postDelayed(NewVcodeView.this.kOA, 500L);
                            if (NewVcodeView.this.kRz != null) {
                                NewVcodeView.this.kRz.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.kRz != null) {
                            return NewVcodeView.this.kRz.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.kOz = true;
                        if (NewVcodeView.this.kRz != null) {
                            NewVcodeView.this.kRz.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.tS(false);
                        NewVcodeView.this.dYz.showToast(R.string.neterror);
                        NewVcodeView.this.dYz.finish();
                    }
                });
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    public void showPostThreadLoadingView(boolean z) {
        if (this.kOw != null) {
            if (z) {
                this.kOw.setVisibility(0);
            } else {
                this.kOw.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.kRD.showSuccessToast(str);
        } else {
            this.kRD.showFailToast(str);
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void runJsMethod(String str, String str2) {
        if (this.mWebView != null) {
            this.mWebView.loadUrl("javascript:window." + str + "(" + str2 + ")");
        }
    }

    public void onDestory() {
        e.gx().removeCallbacks(this.kOA);
    }

    public BaseActivity getContext() {
        return this.dYz;
    }

    public void showWebView(boolean z) {
        tS(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.dYz.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.gx().postDelayed(this.kOA, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS(boolean z) {
        if (this.kOy == null) {
            this.kOy = new a(this.dYz.getPageContext());
            this.kOy.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.dYz.finish();
                }
            });
        }
        this.kOy.setDialogVisiable(z);
    }
}
