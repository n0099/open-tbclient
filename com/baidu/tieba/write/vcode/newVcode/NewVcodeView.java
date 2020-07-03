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
    private BaseActivity eXy;
    private float mRatio;
    private b mqu;
    private BaseWebView mWebView = null;
    private View mmz = null;
    private View mmA = null;
    private a mmC = null;
    private TextView mmB = null;
    private c mqy = null;
    private boolean mmD = false;
    private Runnable mmE = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.eXy = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.mqu = bVar;
        this.mmD = false;
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
        this.mmz = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.mmz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.mqu.drb();
                NewVcodeView.this.eXy.finish();
            }
        });
        this.mmA = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.mmB = (TextView) this.mmA.findViewById(R.id.custom_loading_text);
        this.mmB.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.mqy = new c();
        this.mqy.toastTime = 1000L;
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
                        if (!NewVcodeView.this.mmD) {
                            NewVcodeView.this.mmD = true;
                            e.lt().postDelayed(NewVcodeView.this.mmE, 500L);
                            if (NewVcodeView.this.mqu != null) {
                                NewVcodeView.this.mqu.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.mqu != null) {
                            return NewVcodeView.this.mqu.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.mmD = true;
                        if (NewVcodeView.this.mqu != null) {
                            NewVcodeView.this.mqu.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.vK(false);
                        NewVcodeView.this.eXy.showToast(R.string.neterror);
                        NewVcodeView.this.eXy.finish();
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
        if (this.mmA != null) {
            if (z) {
                this.mmA.setVisibility(0);
            } else {
                this.mmA.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.mqy.showSuccessToast(str);
        } else {
            this.mqy.showFailToast(str);
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
        e.lt().removeCallbacks(this.mmE);
    }

    public BaseActivity getContext() {
        return this.eXy;
    }

    public void showWebView(boolean z) {
        vK(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.eXy.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.lt().postDelayed(this.mmE, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vK(boolean z) {
        if (this.mmC == null) {
            this.mmC = new a(this.eXy.getPageContext());
            this.mmC.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.eXy.finish();
                }
            });
        }
        this.mmC.setDialogVisiable(z);
    }
}
