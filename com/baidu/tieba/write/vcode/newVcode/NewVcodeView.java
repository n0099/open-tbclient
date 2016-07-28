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
    private BaseActivity ate;
    private float fPJ;
    private c fRE;
    private BaseWebView mWebView = null;
    private View cnH = null;
    private View cnI = null;
    private b cnK = null;
    private TextView cnJ = null;
    private h cnM = null;
    private boolean cnV = false;
    private Runnable cnW = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.ate = newVcodeActivity;
        if (!g(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(c cVar) {
        this.fRE = cVar;
    }

    public void setRatio(float f) {
        this.fPJ = f;
    }

    @JavascriptInterface
    private boolean g(NewVcodeActivity newVcodeActivity) {
        newVcodeActivity.setActivityBgTransparent();
        newVcodeActivity.setSwipeBackEnabled(false);
        newVcodeActivity.setContentView(u.h.new_vcode_activity);
        this.cnH = newVcodeActivity.findViewById(u.g.new_vcode_black_layout);
        this.cnH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.fRE.bmZ();
                NewVcodeView.this.ate.finish();
            }
        });
        this.cnI = newVcodeActivity.findViewById(u.g.post_thread_loading_view);
        this.cnJ = (TextView) this.cnI.findViewById(u.g.custom_loading_text);
        this.cnJ.setText(newVcodeActivity.getResources().getString(u.j.sending));
        this.cnM = new h();
        this.cnM.abS = 1000L;
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
                        if (!NewVcodeView.this.cnV) {
                            NewVcodeView.this.cnV = true;
                            com.baidu.adp.lib.h.h.dL().postDelayed(NewVcodeView.this.cnW, 500L);
                            if (NewVcodeView.this.fRE != null) {
                                NewVcodeView.this.fRE.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.fRE != null) {
                            return NewVcodeView.this.fRE.b(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.cnV = true;
                        if (NewVcodeView.this.fRE != null) {
                            NewVcodeView.this.fRE.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.lq(false);
                        NewVcodeView.this.ate.showToast(u.j.neterror);
                        NewVcodeView.this.ate.finish();
                    }
                });
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TbadkCoreApplication.m10getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m10getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    public void showPostThreadLoadingView(boolean z) {
        if (this.cnI != null) {
            if (z) {
                this.cnI.setVisibility(0);
            } else {
                this.cnI.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.cnM.c(str);
        } else {
            this.cnM.d(str);
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
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.cnW);
    }

    public BaseActivity getContext() {
        return this.ate;
    }

    public void showWebView(boolean z) {
        lq(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.ate.getPageContext().getPageActivity(), this.mWebView, this.fPJ);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        com.baidu.adp.lib.h.h.dL().postDelayed(this.cnW, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(boolean z) {
        if (this.cnK == null) {
            this.cnK = new b(this.ate.getPageContext());
            this.cnK.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.ate.finish();
                }
            });
        }
        this.cnK.aE(z);
    }
}
