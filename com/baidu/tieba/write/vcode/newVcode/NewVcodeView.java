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
import com.baidu.tieba.t;
import com.baidu.tieba.write.vcode.newVcode.a.c;
/* loaded from: classes.dex */
public class NewVcodeView {
    private BaseActivity awl;
    private float dP;
    private c gbJ;
    private BaseWebView mWebView = null;
    private View cyQ = null;
    private View cyR = null;
    private a cyT = null;
    private TextView cyS = null;
    private h cyV = null;
    private boolean cze = false;
    private Runnable czf = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.awl = newVcodeActivity;
        if (!g(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(c cVar) {
        this.gbJ = cVar;
        this.cze = false;
    }

    public void setRatio(float f) {
        this.dP = f;
    }

    @JavascriptInterface
    private boolean g(NewVcodeActivity newVcodeActivity) {
        newVcodeActivity.setActivityBgTransparent();
        newVcodeActivity.setSwipeBackEnabled(false);
        newVcodeActivity.setContentView(t.h.new_vcode_activity);
        this.cyQ = newVcodeActivity.findViewById(t.g.new_vcode_black_layout);
        this.cyQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.gbJ.brq();
                NewVcodeView.this.awl.finish();
            }
        });
        this.cyR = newVcodeActivity.findViewById(t.g.post_thread_loading_view);
        this.cyS = (TextView) this.cyR.findViewById(t.g.custom_loading_text);
        this.cyS.setText(newVcodeActivity.getResources().getString(t.j.sending));
        this.cyV = new h();
        this.cyV.aeI = 1000L;
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) newVcodeActivity.findViewById(t.g.new_vcode_webview);
                UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.mWebView, 1.2631578f);
                this.mWebView.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str)) {
                            return false;
                        }
                        if (!NewVcodeView.this.cze) {
                            NewVcodeView.this.cze = true;
                            com.baidu.adp.lib.h.h.eG().postDelayed(NewVcodeView.this.czf, 500L);
                            if (NewVcodeView.this.gbJ != null) {
                                NewVcodeView.this.gbJ.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.gbJ != null) {
                            return NewVcodeView.this.gbJ.b(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.cze = true;
                        if (NewVcodeView.this.gbJ != null) {
                            NewVcodeView.this.gbJ.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.lG(false);
                        NewVcodeView.this.awl.showToast(t.j.neterror);
                        NewVcodeView.this.awl.finish();
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
        if (this.cyR != null) {
            if (z) {
                this.cyR.setVisibility(0);
            } else {
                this.cyR.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.cyV.c(str);
        } else {
            this.cyV.d(str);
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
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.czf);
    }

    public BaseActivity getContext() {
        return this.awl;
    }

    public void showWebView(boolean z) {
        lG(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.awl.getPageContext().getPageActivity(), this.mWebView, this.dP);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        com.baidu.adp.lib.h.h.eG().postDelayed(this.czf, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        if (this.cyT == null) {
            this.cyT = new a(this.awl.getPageContext());
            this.cyT.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.awl.finish();
                }
            });
        }
        this.cyT.aF(z);
    }
}
