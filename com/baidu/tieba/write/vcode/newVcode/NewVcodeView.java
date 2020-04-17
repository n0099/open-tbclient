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
/* loaded from: classes2.dex */
public class NewVcodeView {
    private BaseActivity eyw;
    private b lBx;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View lxM = null;
    private View lxN = null;
    private a lxP = null;
    private TextView lxO = null;
    private d lBB = null;
    private boolean lxQ = false;
    private Runnable lxR = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.eyw = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.lBx = bVar;
        this.lxQ = false;
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
        this.lxM = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.lxM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.lBx.dfl();
                NewVcodeView.this.eyw.finish();
            }
        });
        this.lxN = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.lxO = (TextView) this.lxN.findViewById(R.id.custom_loading_text);
        this.lxO.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.lBB = new d();
        this.lBB.toastTime = 1000L;
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
                        if (!NewVcodeView.this.lxQ) {
                            NewVcodeView.this.lxQ = true;
                            e.lb().postDelayed(NewVcodeView.this.lxR, 500L);
                            if (NewVcodeView.this.lBx != null) {
                                NewVcodeView.this.lBx.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.lBx != null) {
                            return NewVcodeView.this.lBx.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.lxQ = true;
                        if (NewVcodeView.this.lBx != null) {
                            NewVcodeView.this.lBx.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.uS(false);
                        NewVcodeView.this.eyw.showToast(R.string.neterror);
                        NewVcodeView.this.eyw.finish();
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
        if (this.lxN != null) {
            if (z) {
                this.lxN.setVisibility(0);
            } else {
                this.lxN.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.lBB.showSuccessToast(str);
        } else {
            this.lBB.showFailToast(str);
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
        e.lb().removeCallbacks(this.lxR);
    }

    public BaseActivity getContext() {
        return this.eyw;
    }

    public void showWebView(boolean z) {
        uS(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.eyw.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.lb().postDelayed(this.lxR, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(boolean z) {
        if (this.lxP == null) {
            this.lxP = new a(this.eyw.getPageContext());
            this.lxP.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.eyw.finish();
                }
            });
        }
        this.lxP.setDialogVisiable(z);
    }
}
