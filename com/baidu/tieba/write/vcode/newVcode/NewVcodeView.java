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
import com.baidu.tbadk.core.view.c;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.vcode.newVcode.a.b;
/* loaded from: classes7.dex */
public class NewVcodeView {
    private BaseActivity gdS;
    private float mRatio;
    private b nWM;
    private BaseWebView mWebView = null;
    private View nTy = null;
    private View nTz = null;
    private a nTB = null;
    private TextView nTA = null;
    private c nWQ = null;
    private boolean nTC = false;
    private Runnable nTD = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.gdS = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.nWM = bVar;
        this.nTC = false;
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
        this.nTy = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.nTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.nWM.dUs();
                NewVcodeView.this.gdS.finish();
            }
        });
        this.nTz = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.nTA = (TextView) this.nTz.findViewById(R.id.custom_loading_text);
        this.nTA.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.nWQ = new c();
        this.nWQ.toastTime = 1000L;
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
                        if (!NewVcodeView.this.nTC) {
                            NewVcodeView.this.nTC = true;
                            e.mB().postDelayed(NewVcodeView.this.nTD, 500L);
                            if (NewVcodeView.this.nWM != null) {
                                NewVcodeView.this.nWM.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.nWM != null) {
                            return NewVcodeView.this.nWM.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.nTC = true;
                        if (NewVcodeView.this.nWM != null) {
                            NewVcodeView.this.nWM.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.ze(false);
                        NewVcodeView.this.gdS.showToast(R.string.neterror);
                        NewVcodeView.this.gdS.finish();
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
        if (this.nTz != null) {
            if (z) {
                this.nTz.setVisibility(0);
            } else {
                this.nTz.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.nWQ.showSuccessToast(str);
        } else {
            this.nWQ.showFailToast(str);
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
        e.mB().removeCallbacks(this.nTD);
    }

    public BaseActivity getContext() {
        return this.gdS;
    }

    public void showWebView(boolean z) {
        ze(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.gdS.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.mB().postDelayed(this.nTD, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ze(boolean z) {
        if (this.nTB == null) {
            this.nTB = new a(this.gdS.getPageContext());
            this.nTB.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.gdS.finish();
                }
            });
        }
        this.nTB.setDialogVisiable(z);
    }
}
