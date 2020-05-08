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
    private BaseActivity eyB;
    private b lBB;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View lxQ = null;
    private View lxR = null;
    private a lxT = null;
    private TextView lxS = null;
    private d lBF = null;
    private boolean lxU = false;
    private Runnable lxV = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.eyB = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.lBB = bVar;
        this.lxU = false;
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
        this.lxQ = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.lxQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.lBB.dfi();
                NewVcodeView.this.eyB.finish();
            }
        });
        this.lxR = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.lxS = (TextView) this.lxR.findViewById(R.id.custom_loading_text);
        this.lxS.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.lBF = new d();
        this.lBF.toastTime = 1000L;
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
                        if (!NewVcodeView.this.lxU) {
                            NewVcodeView.this.lxU = true;
                            e.lb().postDelayed(NewVcodeView.this.lxV, 500L);
                            if (NewVcodeView.this.lBB != null) {
                                NewVcodeView.this.lBB.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.lBB != null) {
                            return NewVcodeView.this.lBB.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.lxU = true;
                        if (NewVcodeView.this.lBB != null) {
                            NewVcodeView.this.lBB.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.uS(false);
                        NewVcodeView.this.eyB.showToast(R.string.neterror);
                        NewVcodeView.this.eyB.finish();
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
        if (this.lxR != null) {
            if (z) {
                this.lxR.setVisibility(0);
            } else {
                this.lxR.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.lBF.showSuccessToast(str);
        } else {
            this.lBF.showFailToast(str);
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
        e.lb().removeCallbacks(this.lxV);
    }

    public BaseActivity getContext() {
        return this.eyB;
    }

    public void showWebView(boolean z) {
        uS(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.eyB.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.lb().postDelayed(this.lxV, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(boolean z) {
        if (this.lxT == null) {
            this.lxT = new a(this.eyB.getPageContext());
            this.lxT.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.eyB.finish();
                }
            });
        }
        this.lxT.setDialogVisiable(z);
    }
}
