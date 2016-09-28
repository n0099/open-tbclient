package com.baidu.tieba.write.vcode.newVcode;

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
import com.baidu.tbadk.core.view.a;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.r;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes.dex */
public class NewVcodeView {
    private BaseActivity avO;
    private float dP;
    private c gdS;
    private BaseWebView mWebView = null;
    private View czu = null;
    private View czv = null;
    private a czx = null;
    private TextView czw = null;
    private h czz = null;
    private boolean czI = false;
    private Runnable czJ = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.avO = newVcodeActivity;
        if (!g(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(c cVar) {
        this.gdS = cVar;
        this.czI = false;
    }

    public void setRatio(float f) {
        this.dP = f;
    }

    @JavascriptInterface
    private boolean g(NewVcodeActivity newVcodeActivity) {
        newVcodeActivity.setActivityBgTransparent();
        newVcodeActivity.setSwipeBackEnabled(false);
        newVcodeActivity.setContentView(r.h.new_vcode_activity);
        this.czu = newVcodeActivity.findViewById(r.g.new_vcode_black_layout);
        this.czu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.gdS.brW();
                NewVcodeView.this.avO.finish();
            }
        });
        this.czv = newVcodeActivity.findViewById(r.g.post_thread_loading_view);
        this.czw = (TextView) this.czv.findViewById(r.g.custom_loading_text);
        this.czw.setText(newVcodeActivity.getResources().getString(r.j.sending));
        this.czz = new h();
        this.czz.aeT = 1000L;
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) newVcodeActivity.findViewById(r.g.new_vcode_webview);
                UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.mWebView, 1.2631578f);
                this.mWebView.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str)) {
                            return false;
                        }
                        if (!NewVcodeView.this.czI) {
                            NewVcodeView.this.czI = true;
                            com.baidu.adp.lib.h.h.eG().postDelayed(NewVcodeView.this.czJ, 500L);
                            if (NewVcodeView.this.gdS != null) {
                                NewVcodeView.this.gdS.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.gdS != null) {
                            return NewVcodeView.this.gdS.b(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.czI = true;
                        if (NewVcodeView.this.gdS != null) {
                            NewVcodeView.this.gdS.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.lI(false);
                        NewVcodeView.this.avO.showToast(r.j.neterror);
                        NewVcodeView.this.avO.finish();
                    }
                });
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TbadkCoreApplication.m9getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    public void showPostThreadLoadingView(boolean z) {
        if (this.czv != null) {
            if (z) {
                this.czv.setVisibility(0);
            } else {
                this.czv.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.czz.c(str);
        } else {
            this.czz.d(str);
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
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.czJ);
    }

    public BaseActivity getContext() {
        return this.avO;
    }

    public void showWebView(boolean z) {
        lI(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.avO.getPageContext().getPageActivity(), this.mWebView, this.dP);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        com.baidu.adp.lib.h.h.eG().postDelayed(this.czJ, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (this.czx == null) {
            this.czx = new a(this.avO.getPageContext());
            this.czx.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.avO.finish();
                }
            });
        }
        this.czx.aF(z);
    }
}
