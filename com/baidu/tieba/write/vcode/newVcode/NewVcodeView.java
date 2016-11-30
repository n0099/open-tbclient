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
    private BaseActivity awH;
    private float dQ;
    private c glw;
    private BaseWebView mWebView = null;
    private View cEE = null;
    private View cEF = null;
    private a cEH = null;
    private TextView cEG = null;
    private h cEJ = null;
    private boolean cES = false;
    private Runnable cET = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.awH = newVcodeActivity;
        if (!g(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(c cVar) {
        this.glw = cVar;
        this.cES = false;
    }

    public void setRatio(float f) {
        this.dQ = f;
    }

    @JavascriptInterface
    private boolean g(NewVcodeActivity newVcodeActivity) {
        newVcodeActivity.setActivityBgTransparent();
        newVcodeActivity.setSwipeBackEnabled(false);
        newVcodeActivity.setContentView(r.h.new_vcode_activity);
        this.cEE = newVcodeActivity.findViewById(r.g.new_vcode_black_layout);
        this.cEE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.glw.bur();
                NewVcodeView.this.awH.finish();
            }
        });
        this.cEF = newVcodeActivity.findViewById(r.g.post_thread_loading_view);
        this.cEG = (TextView) this.cEF.findViewById(r.g.custom_loading_text);
        this.cEG.setText(newVcodeActivity.getResources().getString(r.j.sending));
        this.cEJ = new h();
        this.cEJ.afr = 1000L;
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) newVcodeActivity.findViewById(r.g.new_vcode_webview);
                UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.mWebView, 1.2631578f);
                this.mWebView.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str)) {
                            return false;
                        }
                        if (!NewVcodeView.this.cES) {
                            NewVcodeView.this.cES = true;
                            com.baidu.adp.lib.h.h.eG().postDelayed(NewVcodeView.this.cET, 500L);
                            if (NewVcodeView.this.glw != null) {
                                NewVcodeView.this.glw.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.glw != null) {
                            return NewVcodeView.this.glw.b(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.cES = true;
                        if (NewVcodeView.this.glw != null) {
                            NewVcodeView.this.glw.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.mh(false);
                        NewVcodeView.this.awH.showToast(r.j.neterror);
                        NewVcodeView.this.awH.finish();
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
        if (this.cEF != null) {
            if (z) {
                this.cEF.setVisibility(0);
            } else {
                this.cEF.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.cEJ.c(str);
        } else {
            this.cEJ.d(str);
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
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cET);
    }

    public BaseActivity getContext() {
        return this.awH;
    }

    public void showWebView(boolean z) {
        mh(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.awH.getPageContext().getPageActivity(), this.mWebView, this.dQ);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        com.baidu.adp.lib.h.h.eG().postDelayed(this.cET, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh(boolean z) {
        if (this.cEH == null) {
            this.cEH = new a(this.awH.getPageContext());
            this.cEH.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.awH.finish();
                }
            });
        }
        this.cEH.aI(z);
    }
}
