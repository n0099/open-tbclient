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
/* loaded from: classes8.dex */
public class NewVcodeView {
    private BaseActivity ggm;
    private float mRatio;
    private b oht;
    private BaseWebView mWebView = null;
    private View oef = null;
    private View oeg = null;
    private a oei = null;
    private TextView oeh = null;
    private c ohx = null;
    private boolean oej = false;
    private Runnable oek = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.ggm = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.oht = bVar;
        this.oej = false;
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
        this.oef = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.oef.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.oht.dWO();
                NewVcodeView.this.ggm.finish();
            }
        });
        this.oeg = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.oeh = (TextView) this.oeg.findViewById(R.id.custom_loading_text);
        this.oeh.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.ohx = new c();
        this.ohx.toastTime = 1000L;
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
                        if (!NewVcodeView.this.oej) {
                            NewVcodeView.this.oej = true;
                            e.mA().postDelayed(NewVcodeView.this.oek, 500L);
                            if (NewVcodeView.this.oht != null) {
                                NewVcodeView.this.oht.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.oht != null) {
                            return NewVcodeView.this.oht.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.oej = true;
                        if (NewVcodeView.this.oht != null) {
                            NewVcodeView.this.oht.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.zA(false);
                        NewVcodeView.this.ggm.showToast(R.string.neterror);
                        NewVcodeView.this.ggm.finish();
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
        if (this.oeg != null) {
            if (z) {
                this.oeg.setVisibility(0);
            } else {
                this.oeg.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.ohx.showSuccessToast(str);
        } else {
            this.ohx.showFailToast(str);
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
        e.mA().removeCallbacks(this.oek);
    }

    public BaseActivity getContext() {
        return this.ggm;
    }

    public void showWebView(boolean z) {
        zA(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.ggm.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.mA().postDelayed(this.oek, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(boolean z) {
        if (this.oei == null) {
            this.oei = new a(this.ggm.getPageContext());
            this.oei.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.ggm.finish();
                }
            });
        }
        this.oei.setDialogVisiable(z);
    }
}
