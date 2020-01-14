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
/* loaded from: classes11.dex */
public class NewVcodeView {
    private BaseActivity dTQ;
    private b kPf;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View kLS = null;
    private View kLT = null;
    private a kLV = null;
    private TextView kLU = null;
    private d kPj = null;
    private boolean kLW = false;
    private Runnable kLX = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.dTQ = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.kPf = bVar;
        this.kLW = false;
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
        this.kLS = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.kLS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.kPf.cTe();
                NewVcodeView.this.dTQ.finish();
            }
        });
        this.kLT = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.kLU = (TextView) this.kLT.findViewById(R.id.custom_loading_text);
        this.kLU.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.kPj = new d();
        this.kPj.toastTime = 1000L;
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
                        if (!NewVcodeView.this.kLW) {
                            NewVcodeView.this.kLW = true;
                            e.gx().postDelayed(NewVcodeView.this.kLX, 500L);
                            if (NewVcodeView.this.kPf != null) {
                                NewVcodeView.this.kPf.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.kPf != null) {
                            return NewVcodeView.this.kPf.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.kLW = true;
                        if (NewVcodeView.this.kPf != null) {
                            NewVcodeView.this.kPf.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.tH(false);
                        NewVcodeView.this.dTQ.showToast(R.string.neterror);
                        NewVcodeView.this.dTQ.finish();
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
        if (this.kLT != null) {
            if (z) {
                this.kLT.setVisibility(0);
            } else {
                this.kLT.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.kPj.showSuccessToast(str);
        } else {
            this.kPj.showFailToast(str);
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
        e.gx().removeCallbacks(this.kLX);
    }

    public BaseActivity getContext() {
        return this.dTQ;
    }

    public void showWebView(boolean z) {
        tH(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.dTQ.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.gx().postDelayed(this.kLX, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH(boolean z) {
        if (this.kLV == null) {
            this.kLV = new a(this.dTQ.getPageContext());
            this.kLV.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.dTQ.finish();
                }
            });
        }
        this.kLV.setDialogVisiable(z);
    }
}
