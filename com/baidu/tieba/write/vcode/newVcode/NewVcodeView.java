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
import com.baidu.tbadk.core.view.b;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.u;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes.dex */
public class NewVcodeView {
    private BaseActivity asp;
    private c fFA;
    private float fFF;
    private BaseWebView mWebView = null;
    private View cls = null;
    private View clt = null;
    private b clv = null;
    private TextView clu = null;
    private h clx = null;
    private boolean clG = false;
    private Runnable clH = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.asp = newVcodeActivity;
        if (!g(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(c cVar) {
        this.fFA = cVar;
    }

    public void setRatio(float f) {
        this.fFF = f;
    }

    @JavascriptInterface
    private boolean g(NewVcodeActivity newVcodeActivity) {
        newVcodeActivity.setActivityBgTransparent();
        newVcodeActivity.setSwipeBackEnabled(false);
        newVcodeActivity.setContentView(u.h.new_vcode_activity);
        this.cls = newVcodeActivity.findViewById(u.g.new_vcode_black_layout);
        this.cls.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.fFA.bkV();
                NewVcodeView.this.asp.finish();
            }
        });
        this.clt = newVcodeActivity.findViewById(u.g.post_thread_loading_view);
        this.clu = (TextView) this.clt.findViewById(u.g.custom_loading_text);
        this.clu.setText(newVcodeActivity.getResources().getString(u.j.sending));
        this.clx = new h();
        this.clx.abh = 1000L;
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) newVcodeActivity.findViewById(u.g.new_vcode_webview);
                UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.mWebView, 1.2631578f);
                this.mWebView.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str)) {
                            return false;
                        }
                        if (!NewVcodeView.this.clG) {
                            NewVcodeView.this.clG = true;
                            com.baidu.adp.lib.h.h.dM().postDelayed(NewVcodeView.this.clH, 500L);
                            if (NewVcodeView.this.fFA != null) {
                                NewVcodeView.this.fFA.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.fFA != null) {
                            return NewVcodeView.this.fFA.b(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.clG = true;
                        if (NewVcodeView.this.fFA != null) {
                            NewVcodeView.this.fFA.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.lg(false);
                        NewVcodeView.this.asp.showToast(u.j.neterror);
                        NewVcodeView.this.asp.finish();
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
        if (this.clt != null) {
            if (z) {
                this.clt.setVisibility(0);
            } else {
                this.clt.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.clx.c(str);
        } else {
            this.clx.d(str);
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
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.clH);
    }

    public BaseActivity getContext() {
        return this.asp;
    }

    public void showWebView(boolean z) {
        lg(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.asp.getPageContext().getPageActivity(), this.mWebView, this.fFF);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        com.baidu.adp.lib.h.h.dM().postDelayed(this.clH, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg(boolean z) {
        if (this.clv == null) {
            this.clv = new b(this.asp.getPageContext());
            this.clv.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.asp.finish();
                }
            });
        }
        this.clv.aB(z);
    }
}
