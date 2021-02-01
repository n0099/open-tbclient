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
    private BaseActivity ggh;
    private float mRatio;
    private b ogT;
    private BaseWebView mWebView = null;
    private View odF = null;
    private View odG = null;
    private a odI = null;
    private TextView odH = null;
    private c ogX = null;
    private boolean odJ = false;
    private Runnable odK = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.ggh = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.ogT = bVar;
        this.odJ = false;
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
        this.odF = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.odF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.ogT.dWG();
                NewVcodeView.this.ggh.finish();
            }
        });
        this.odG = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.odH = (TextView) this.odG.findViewById(R.id.custom_loading_text);
        this.odH.setText(newVcodeActivity.getResources().getString(R.string.sending));
        this.ogX = new c();
        this.ogX.toastTime = 1000L;
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
                        if (!NewVcodeView.this.odJ) {
                            NewVcodeView.this.odJ = true;
                            e.mA().postDelayed(NewVcodeView.this.odK, 500L);
                            if (NewVcodeView.this.ogT != null) {
                                NewVcodeView.this.ogT.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.ogT != null) {
                            return NewVcodeView.this.ogT.c(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.odJ = true;
                        if (NewVcodeView.this.ogT != null) {
                            NewVcodeView.this.ogT.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.zA(false);
                        NewVcodeView.this.ggh.showToast(R.string.neterror);
                        NewVcodeView.this.ggh.finish();
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
        if (this.odG != null) {
            if (z) {
                this.odG.setVisibility(0);
            } else {
                this.odG.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.ogX.showSuccessToast(str);
        } else {
            this.ogX.showFailToast(str);
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
        e.mA().removeCallbacks(this.odK);
    }

    public BaseActivity getContext() {
        return this.ggh;
    }

    public void showWebView(boolean z) {
        zA(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.ggh.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.mA().postDelayed(this.odK, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(boolean z) {
        if (this.odI == null) {
            this.odI = new a(this.ggh.getPageContext());
            this.odI.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.ggh.finish();
                }
            });
        }
        this.odI.setDialogVisiable(z);
    }
}
