package com.baidu.tieba.write.accountAccess;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.c;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private float gyC;
    private BaseActivity mContext;
    private a gyx = null;
    private View mBlackBackLayout = null;
    private BaseWebView mWebView = null;
    private View mPostThreadLoadingView = null;
    private TextView mPostThreadLoadingText = null;
    private com.baidu.tbadk.core.view.a mWebLoadingDialog = null;
    private c gyD = null;
    private boolean onPageFinishHasBeenCalled = false;
    private float mRatio = 1.2631578f;
    private Runnable mShowWebViewRunnable = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.showWebLoadingView(false);
                b.this.bxF();
            }
        }
    };
    private Runnable gyE = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mContext != null) {
                b.this.mContext.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.mContext = null;
        if (accountAccessActivity != null) {
            this.mContext = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.gyx = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(d.j.account_access_activity);
        this.mBlackBackLayout = accountAccessActivity.findViewById(d.h.account_access_black_layout);
        this.mBlackBackLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gyx.onPostThreadCancle();
                b.this.mContext.finish();
            }
        });
        this.mPostThreadLoadingView = accountAccessActivity.findViewById(d.h.aa_post_thread_loading_view);
        this.mPostThreadLoadingText = (TextView) this.mPostThreadLoadingView.findViewById(d.h.custom_loading_text);
        this.mPostThreadLoadingText.setText(accountAccessActivity.getResources().getString(d.l.sending));
        this.gyD = new c();
        this.gyD.ajS = 1000L;
        this.gyC = k.af(accountAccessActivity.getBaseContext()) / k.ag(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(d.h.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.gyx == null) {
                            return false;
                        }
                        if (!b.this.onPageFinishHasBeenCalled) {
                            b.this.onPageFinishHasBeenCalled = true;
                            b.this.showWebLoadingView(false);
                            b.this.bxF();
                            b.this.gyx.bxB();
                            return true;
                        }
                        return b.this.gyx.sL(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.onPageFinishHasBeenCalled = true;
                        if (b.this.gyx != null) {
                            b.this.gyx.bxB();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.showWebLoadingView(false);
                        b.this.mContext.showToast(d.l.neterror);
                        b.this.mContext.finish();
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

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.fP().removeCallbacks(this.mShowWebViewRunnable);
        e.fP().removeCallbacks(this.gyE);
        this.mWebLoadingDialog = null;
    }

    public BaseActivity getContext() {
        return this.mContext;
    }

    public void showWebView(boolean z) {
        if (this.mWebView != null) {
            if (z) {
                this.mWebView.setVisibility(0);
            } else {
                this.mWebView.setVisibility(4);
            }
        }
    }

    public void showWebViewDelay(int i) {
        e.fP().postDelayed(this.mShowWebViewRunnable, i);
    }

    public void showWebLoadingView(boolean z) {
        if (this.mWebLoadingDialog == null) {
            this.mWebLoadingDialog = new com.baidu.tbadk.core.view.a(this.mContext.getPageContext());
            this.mWebLoadingDialog.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.mContext.finish();
                }
            });
        }
        this.mWebLoadingDialog.aH(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.mContext.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float bm() {
        return this.mRatio;
    }

    public float bxE() {
        return this.gyC;
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation m(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void bxF() {
        if (this.mContext != null) {
            if (this.mRatio == this.gyC) {
                this.mWebView.startAnimation(m(k.ag(this.mContext.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.fP().postDelayed(this.gyE, 800L);
                return;
            }
            this.mWebView.startAnimation(m(this.mWebView.getHeight(), 0.0f));
        }
    }
}
