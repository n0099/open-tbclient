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
/* loaded from: classes3.dex */
public class NewVcodeView {
    private BaseActivity fYS;
    private float mRatio;
    private b nYx;
    private BaseWebView mWebView = null;
    private View nUH = null;
    private View nUI = null;
    private a nUK = null;
    private TextView nUJ = null;
    private c nYB = null;
    private boolean nUL = false;
    private Runnable nUM = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.fYS = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.nYx = bVar;
        this.nUL = false;
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
        this.nUH = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.nUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.nYx.dYE();
                NewVcodeView.this.fYS.finish();
            }
        });
        this.nUI = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.nUJ = (TextView) this.nUI.findViewById(R.id.custom_loading_text);
        this.nUJ.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.nYB = new c();
        this.nYB.toastTime = 1000L;
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
                        if (!NewVcodeView.this.nUL) {
                            NewVcodeView.this.nUL = true;
                            e.mY().postDelayed(NewVcodeView.this.nUM, 500L);
                            if (NewVcodeView.this.nYx != null) {
                                NewVcodeView.this.nYx.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.nYx != null) {
                            return NewVcodeView.this.nYx.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.nUL = true;
                        if (NewVcodeView.this.nYx != null) {
                            NewVcodeView.this.nYx.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.zh(false);
                        NewVcodeView.this.fYS.showToast(R.string.neterror);
                        NewVcodeView.this.fYS.finish();
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
        if (this.nUI != null) {
            if (z) {
                this.nUI.setVisibility(0);
            } else {
                this.nUI.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.nYB.showSuccessToast(str);
        } else {
            this.nYB.showFailToast(str);
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
        e.mY().removeCallbacks(this.nUM);
    }

    public BaseActivity getContext() {
        return this.fYS;
    }

    public void showWebView(boolean z) {
        zh(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.fYS.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.mY().postDelayed(this.nUM, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(boolean z) {
        if (this.nUK == null) {
            this.nUK = new a(this.fYS.getPageContext());
            this.nUK.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.fYS.finish();
                }
            });
        }
        this.nUK.setDialogVisiable(z);
    }
}
