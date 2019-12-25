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
/* loaded from: classes10.dex */
public class NewVcodeView {
    private BaseActivity dTH;
    private b kLz;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View kIm = null;
    private View kIn = null;
    private a kIp = null;
    private TextView kIo = null;
    private d kLD = null;
    private boolean kIq = false;
    private Runnable kIr = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.dTH = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.kLz = bVar;
        this.kIq = false;
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
        this.kIm = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.kIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.kLz.cRZ();
                NewVcodeView.this.dTH.finish();
            }
        });
        this.kIn = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.kIo = (TextView) this.kIn.findViewById(R.id.custom_loading_text);
        this.kIo.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.kLD = new d();
        this.kLD.toastTime = 1000L;
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
                        if (!NewVcodeView.this.kIq) {
                            NewVcodeView.this.kIq = true;
                            e.gy().postDelayed(NewVcodeView.this.kIr, 500L);
                            if (NewVcodeView.this.kLz != null) {
                                NewVcodeView.this.kLz.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.kLz != null) {
                            return NewVcodeView.this.kLz.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.kIq = true;
                        if (NewVcodeView.this.kLz != null) {
                            NewVcodeView.this.kLz.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.tv(false);
                        NewVcodeView.this.dTH.showToast(R.string.neterror);
                        NewVcodeView.this.dTH.finish();
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
        if (this.kIn != null) {
            if (z) {
                this.kIn.setVisibility(0);
            } else {
                this.kIn.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.kLD.showSuccessToast(str);
        } else {
            this.kLD.showFailToast(str);
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
        e.gy().removeCallbacks(this.kIr);
    }

    public BaseActivity getContext() {
        return this.dTH;
    }

    public void showWebView(boolean z) {
        tv(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.dTH.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.gy().postDelayed(this.kIr, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(boolean z) {
        if (this.kIp == null) {
            this.kIp = new a(this.dTH.getPageContext());
            this.kIp.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.dTH.finish();
                }
            });
        }
        this.kIp.setDialogVisiable(z);
    }
}
