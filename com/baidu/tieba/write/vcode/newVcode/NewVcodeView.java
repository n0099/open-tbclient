package com.baidu.tieba.write.vcode.newVcode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.a;
import com.baidu.tbadk.core.view.c;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.vcode.newVcode.a.b;
/* loaded from: classes2.dex */
public class NewVcodeView {
    private b gJo;
    private BaseActivity mContext;
    private float mRatio;
    private BaseWebView mWebView = null;
    private View mBlackBackLayout = null;
    private View mPostThreadLoadingView = null;
    private a mWebLoadingDialog = null;
    private TextView mPostThreadLoadingText = null;
    private c mVcodeToast = null;
    private boolean onPageFinishHasBeenCalled = false;
    private Runnable mShowWebViewRunnable = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.mWebView != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.mContext = newVcodeActivity;
        if (!initUI(newVcodeActivity)) {
            newVcodeActivity.finish();
        }
    }

    public void setPresenter(b bVar) {
        this.gJo = bVar;
        this.onPageFinishHasBeenCalled = false;
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    @JavascriptInterface
    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean initUI(NewVcodeActivity newVcodeActivity) {
        newVcodeActivity.setActivityBgTransparent();
        newVcodeActivity.setSwipeBackEnabled(false);
        newVcodeActivity.setContentView(d.j.new_vcode_activity);
        this.mBlackBackLayout = newVcodeActivity.findViewById(d.h.new_vcode_black_layout);
        this.mBlackBackLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.gJo.onPostThreadCancle();
                NewVcodeView.this.mContext.finish();
            }
        });
        this.mPostThreadLoadingView = newVcodeActivity.findViewById(d.h.post_thread_loading_view);
        this.mPostThreadLoadingText = (TextView) this.mPostThreadLoadingView.findViewById(d.h.custom_loading_text);
        this.mPostThreadLoadingText.setText(newVcodeActivity.getResources().getString(d.l.sending));
        this.mVcodeToast = new c();
        this.mVcodeToast.akH = 1000L;
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) newVcodeActivity.findViewById(d.h.new_vcode_webview);
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
                        if (!NewVcodeView.this.onPageFinishHasBeenCalled) {
                            NewVcodeView.this.onPageFinishHasBeenCalled = true;
                            e.fP().postDelayed(NewVcodeView.this.mShowWebViewRunnable, 500L);
                            if (NewVcodeView.this.gJo != null) {
                                NewVcodeView.this.gJo.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.gJo != null) {
                            return NewVcodeView.this.gJo.onUrlLoad(webView, str);
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.onPageFinishHasBeenCalled = true;
                        if (NewVcodeView.this.gJo != null) {
                            NewVcodeView.this.gJo.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.showWebLoadingView(false);
                        NewVcodeView.this.mContext.showToast(d.l.neterror);
                        NewVcodeView.this.mContext.finish();
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
        if (this.mPostThreadLoadingView != null) {
            if (z) {
                this.mPostThreadLoadingView.setVisibility(0);
            } else {
                this.mPostThreadLoadingView.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.mVcodeToast.c(str);
        } else {
            this.mVcodeToast.d(str);
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
        e.fP().removeCallbacks(this.mShowWebViewRunnable);
    }

    public BaseActivity getContext() {
        return this.mContext;
    }

    public void showWebView(boolean z) {
        showWebLoadingView(!z);
        if (this.mWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.mContext.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setVisibility(0);
                return;
            }
            this.mWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.fP().postDelayed(this.mShowWebViewRunnable, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebLoadingView(boolean z) {
        if (this.mWebLoadingDialog == null) {
            this.mWebLoadingDialog = new a(this.mContext.getPageContext());
            this.mWebLoadingDialog.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.mContext.finish();
                }
            });
        }
        this.mWebLoadingDialog.aH(z);
    }
}
