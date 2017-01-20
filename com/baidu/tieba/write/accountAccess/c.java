package com.baidu.tieba.write.accountAccess;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c {
    private float fGA;
    private BaseActivity mContext;
    private a fGw = null;
    private View mBlackBackLayout = null;
    private BaseWebView mWebView = null;
    private View mPostThreadLoadingView = null;
    private TextView mPostThreadLoadingText = null;
    private com.baidu.tbadk.core.view.a mWebLoadingDialog = null;
    private com.baidu.tbadk.core.view.h fGB = null;
    private boolean onPageFinishHasBeenCalled = false;
    private float mRatio = 1.2631578f;
    private Runnable mShowWebViewRunnable = new d(this);
    private Runnable fGC = new e(this);

    public c(AccountAccessActivity accountAccessActivity) {
        this.mContext = null;
        if (accountAccessActivity != null) {
            this.mContext = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.fGw = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(r.j.account_access_activity);
        this.mBlackBackLayout = accountAccessActivity.findViewById(r.h.account_access_black_layout);
        this.mBlackBackLayout.setOnClickListener(new f(this));
        this.mPostThreadLoadingView = accountAccessActivity.findViewById(r.h.aa_post_thread_loading_view);
        this.mPostThreadLoadingText = (TextView) this.mPostThreadLoadingView.findViewById(r.h.custom_loading_text);
        this.mPostThreadLoadingText.setText(accountAccessActivity.getResources().getString(r.l.sending));
        this.fGB = new com.baidu.tbadk.core.view.h();
        this.fGB.adV = 1000L;
        this.fGA = k.I(accountAccessActivity.getBaseContext()) / k.J(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(r.h.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new g(this));
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
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.mShowWebViewRunnable);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.fGC);
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
        com.baidu.adp.lib.g.h.eE().postDelayed(this.mShowWebViewRunnable, i);
    }

    public void showWebLoadingView(boolean z) {
        if (this.mWebLoadingDialog == null) {
            this.mWebLoadingDialog = new com.baidu.tbadk.core.view.a(this.mContext.getPageContext());
            this.mWebLoadingDialog.c(new h(this));
        }
        this.mWebLoadingDialog.aJ(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.mContext.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float ad() {
        return this.mRatio;
    }

    public float bmI() {
        return this.fGA;
    }

    public void s(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation i(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void bmJ() {
        if (this.mContext != null) {
            if (this.mRatio == this.fGA) {
                this.mWebView.startAnimation(i(k.J(this.mContext.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                com.baidu.adp.lib.g.h.eE().postDelayed(this.fGC, 800L);
                return;
            }
            this.mWebView.startAnimation(i(this.mWebView.getHeight(), 0.0f));
        }
    }
}
