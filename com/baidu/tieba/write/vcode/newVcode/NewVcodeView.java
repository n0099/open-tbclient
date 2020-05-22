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
/* loaded from: classes2.dex */
public class NewVcodeView {
    private BaseActivity eNb;
    private b lUP;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View lRf = null;
    private View lRg = null;
    private a lRi = null;
    private TextView lRh = null;
    private c lUT = null;
    private boolean lRj = false;
    private Runnable lRk = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.eNb = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.lUP = bVar;
        this.lRj = false;
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
        this.lRf = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.lRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.lUP.dmz();
                NewVcodeView.this.eNb.finish();
            }
        });
        this.lRg = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.lRh = (TextView) this.lRg.findViewById(R.id.custom_loading_text);
        this.lRh.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.lUT = new c();
        this.lUT.toastTime = 1000L;
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
                        if (!NewVcodeView.this.lRj) {
                            NewVcodeView.this.lRj = true;
                            e.ld().postDelayed(NewVcodeView.this.lRk, 500L);
                            if (NewVcodeView.this.lUP != null) {
                                NewVcodeView.this.lUP.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.lUP != null) {
                            return NewVcodeView.this.lUP.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.lRj = true;
                        if (NewVcodeView.this.lUP != null) {
                            NewVcodeView.this.lUP.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.vq(false);
                        NewVcodeView.this.eNb.showToast(R.string.neterror);
                        NewVcodeView.this.eNb.finish();
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
        if (this.lRg != null) {
            if (z) {
                this.lRg.setVisibility(0);
            } else {
                this.lRg.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.lUT.showSuccessToast(str);
        } else {
            this.lUT.showFailToast(str);
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
        e.ld().removeCallbacks(this.lRk);
    }

    public BaseActivity getContext() {
        return this.eNb;
    }

    public void showWebView(boolean z) {
        vq(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.eNb.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.ld().postDelayed(this.lRk, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(boolean z) {
        if (this.lRi == null) {
            this.lRi = new a(this.eNb.getPageContext());
            this.lRi.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.eNb.finish();
                }
            });
        }
        this.lRi.setDialogVisiable(z);
    }
}
