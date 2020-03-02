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
    private BaseActivity dXW;
    private b kPN;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View kMA = null;
    private View kMB = null;
    private a kMD = null;
    private TextView kMC = null;
    private d kPR = null;
    private boolean kME = false;
    private Runnable kMF = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.dXW = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.kPN = bVar;
        this.kME = false;
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
        this.kMA = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.kMA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.kPN.cUu();
                NewVcodeView.this.dXW.finish();
            }
        });
        this.kMB = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.kMC = (TextView) this.kMB.findViewById(R.id.custom_loading_text);
        this.kMC.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.kPR = new d();
        this.kPR.toastTime = 1000L;
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
                        if (!NewVcodeView.this.kME) {
                            NewVcodeView.this.kME = true;
                            e.gx().postDelayed(NewVcodeView.this.kMF, 500L);
                            if (NewVcodeView.this.kPN != null) {
                                NewVcodeView.this.kPN.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.kPN != null) {
                            return NewVcodeView.this.kPN.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.kME = true;
                        if (NewVcodeView.this.kPN != null) {
                            NewVcodeView.this.kPN.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.tL(false);
                        NewVcodeView.this.dXW.showToast(R.string.neterror);
                        NewVcodeView.this.dXW.finish();
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
        if (this.kMB != null) {
            if (z) {
                this.kMB.setVisibility(0);
            } else {
                this.kMB.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.kPR.showSuccessToast(str);
        } else {
            this.kPR.showFailToast(str);
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
        e.gx().removeCallbacks(this.kMF);
    }

    public BaseActivity getContext() {
        return this.dXW;
    }

    public void showWebView(boolean z) {
        tL(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.dXW.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.gx().postDelayed(this.kMF, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL(boolean z) {
        if (this.kMD == null) {
            this.kMD = new a(this.dXW.getPageContext());
            this.kMD.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.dXW.finish();
                }
            });
        }
        this.kMD.setDialogVisiable(z);
    }
}
