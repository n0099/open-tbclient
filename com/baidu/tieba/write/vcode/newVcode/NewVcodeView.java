package com.baidu.tieba.write.vcode.newVcode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.vcode.newVcode.a.b;
/* loaded from: classes3.dex */
public class NewVcodeView {
    private BaseActivity cGd;
    private b jQN;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View jNy = null;
    private View jNz = null;
    private com.baidu.tbadk.core.view.b jNB = null;
    private TextView jNA = null;
    private e jQR = null;
    private boolean jNC = false;
    private Runnable jND = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.cGd = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.jQN = bVar;
        this.jNC = false;
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
        this.jNy = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.jNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.jQN.cxX();
                NewVcodeView.this.cGd.finish();
            }
        });
        this.jNz = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.jNA = (TextView) this.jNz.findViewById(R.id.custom_loading_text);
        this.jNA.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.jQR = new e();
        this.jQR.toastTime = 1000L;
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
                        if (!NewVcodeView.this.jNC) {
                            NewVcodeView.this.jNC = true;
                            com.baidu.adp.lib.g.e.fZ().postDelayed(NewVcodeView.this.jND, 500L);
                            if (NewVcodeView.this.jQN != null) {
                                NewVcodeView.this.jQN.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.jQN != null) {
                            return NewVcodeView.this.jQN.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.jNC = true;
                        if (NewVcodeView.this.jQN != null) {
                            NewVcodeView.this.jQN.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.rP(false);
                        NewVcodeView.this.cGd.showToast(R.string.neterror);
                        NewVcodeView.this.cGd.finish();
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
        if (this.jNz != null) {
            if (z) {
                this.jNz.setVisibility(0);
            } else {
                this.jNz.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.jQR.showSuccessToast(str);
        } else {
            this.jQR.showFailToast(str);
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
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.jND);
    }

    public BaseActivity getContext() {
        return this.cGd;
    }

    public void showWebView(boolean z) {
        rP(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.cGd.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.jND, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(boolean z) {
        if (this.jNB == null) {
            this.jNB = new com.baidu.tbadk.core.view.b(this.cGd.getPageContext());
            this.jNB.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.cGd.finish();
                }
            });
        }
        this.jNB.setDialogVisiable(z);
    }
}
