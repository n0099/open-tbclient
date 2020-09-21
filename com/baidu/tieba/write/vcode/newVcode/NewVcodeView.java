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
/* loaded from: classes3.dex */
public class NewVcodeView {
    private BaseActivity fqC;
    private float mRatio;
    private b naY;
    private BaseWebView mWebView = null;
    private View mXh = null;
    private View mXi = null;
    private a mXk = null;
    private TextView mXj = null;
    private c nbc = null;
    private boolean mXl = false;
    private Runnable mXm = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.fqC = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.naY = bVar;
        this.mXl = false;
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
        this.mXh = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.mXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.naY.dJR();
                NewVcodeView.this.fqC.finish();
            }
        });
        this.mXi = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.mXj = (TextView) this.mXi.findViewById(R.id.custom_loading_text);
        this.mXj.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.nbc = new c();
        this.nbc.toastTime = 1000L;
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
                        if (!NewVcodeView.this.mXl) {
                            NewVcodeView.this.mXl = true;
                            e.mX().postDelayed(NewVcodeView.this.mXm, 500L);
                            if (NewVcodeView.this.naY != null) {
                                NewVcodeView.this.naY.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.naY != null) {
                            return NewVcodeView.this.naY.b(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.mXl = true;
                        if (NewVcodeView.this.naY != null) {
                            NewVcodeView.this.naY.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.xo(false);
                        NewVcodeView.this.fqC.showToast(R.string.neterror);
                        NewVcodeView.this.fqC.finish();
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
        if (this.mXi != null) {
            if (z) {
                this.mXi.setVisibility(0);
            } else {
                this.mXi.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.nbc.showSuccessToast(str);
        } else {
            this.nbc.showFailToast(str);
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
        e.mX().removeCallbacks(this.mXm);
    }

    public BaseActivity getContext() {
        return this.fqC;
    }

    public void showWebView(boolean z) {
        xo(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.fqC.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.mX().postDelayed(this.mXm, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xo(boolean z) {
        if (this.mXk == null) {
            this.mXk = new a(this.fqC.getPageContext());
            this.mXk.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.fqC.finish();
                }
            });
        }
        this.mXk.setDialogVisiable(z);
    }
}
