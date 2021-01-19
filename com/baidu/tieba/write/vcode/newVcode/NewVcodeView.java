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
    private b nWN;
    private BaseWebView mWebView = null;
    private View nTz = null;
    private View nTA = null;
    private a nTC = null;
    private TextView nTB = null;
    private c nWR = null;
    private boolean nTD = false;
    private Runnable nTE = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
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
        this.nWN = bVar;
        this.nTD = false;
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
        this.nTz = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.nTz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.nWN.dUs();
                NewVcodeView.this.gdS.finish();
            }
        });
        this.nTA = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.nTB = (TextView) this.nTA.findViewById(R.id.custom_loading_text);
        this.nTB.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.nWR = new c();
        this.nWR.toastTime = 1000L;
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
                        if (!NewVcodeView.this.nTD) {
                            NewVcodeView.this.nTD = true;
                            e.mB().postDelayed(NewVcodeView.this.nTE, 500L);
                            if (NewVcodeView.this.nWN != null) {
                                NewVcodeView.this.nWN.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.nWN != null) {
                            return NewVcodeView.this.nWN.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.nTD = true;
                        if (NewVcodeView.this.nWN != null) {
                            NewVcodeView.this.nWN.onPageFinished(webView, str);
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
        if (this.nTA != null) {
            if (z) {
                this.nTA.setVisibility(0);
            } else {
                this.nTA.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.nWR.showSuccessToast(str);
        } else {
            this.nWR.showFailToast(str);
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
        e.mB().removeCallbacks(this.nTE);
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
        e.mB().postDelayed(this.nTE, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ze(boolean z) {
        if (this.nTC == null) {
            this.nTC = new a(this.gdS.getPageContext());
            this.nTC.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.gdS.finish();
                }
            });
        }
        this.nTC.setDialogVisiable(z);
    }
}
