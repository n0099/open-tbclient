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
    private BaseActivity awe;
    private float fxV;
    private a fxQ = null;
    private View cjU = null;
    private BaseWebView mWebView = null;
    private View cjV = null;
    private TextView cjW = null;
    private com.baidu.tbadk.core.view.a cjX = null;
    private com.baidu.tbadk.core.view.h fxW = null;
    private boolean cki = false;
    private float dQ = 1.2631578f;
    private Runnable ckj = new d(this);
    private Runnable fxX = new e(this);

    public c(AccountAccessActivity accountAccessActivity) {
        this.awe = null;
        if (accountAccessActivity != null) {
            this.awe = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.fxQ = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(r.h.account_access_activity);
        this.cjU = accountAccessActivity.findViewById(r.g.account_access_black_layout);
        this.cjU.setOnClickListener(new f(this));
        this.cjV = accountAccessActivity.findViewById(r.g.aa_post_thread_loading_view);
        this.cjW = (TextView) this.cjV.findViewById(r.g.custom_loading_text);
        this.cjW.setText(accountAccessActivity.getResources().getString(r.j.sending));
        this.fxW = new com.baidu.tbadk.core.view.h();
        this.fxW.aeK = 1000L;
        this.fxV = k.I(accountAccessActivity.getBaseContext()) / k.J(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(r.g.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.dQ);
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
        if (this.cjV != null) {
            if (z) {
                this.cjV.setVisibility(0);
            } else {
                this.cjV.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ckj);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fxX);
        this.cjX = null;
    }

    public BaseActivity getContext() {
        return this.awe;
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
        com.baidu.adp.lib.h.h.eG().postDelayed(this.ckj, i);
    }

    public void lv(boolean z) {
        if (this.cjX == null) {
            this.cjX = new com.baidu.tbadk.core.view.a(this.awe.getPageContext());
            this.cjX.c(new h(this));
        }
        this.cjX.aJ(z);
    }

    public void setRatio(float f) {
        this.dQ = f;
        UtilHelper.setSupportHeight(this.awe.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float ad() {
        return this.dQ;
    }

    public float blk() {
        return this.fxV;
    }

    public void t(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation k(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void bll() {
        if (this.awe != null) {
            if (this.dQ == this.fxV) {
                this.mWebView.startAnimation(k(k.J(this.awe.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                com.baidu.adp.lib.h.h.eG().postDelayed(this.fxX, 800L);
                return;
            }
            this.mWebView.startAnimation(k(this.mWebView.getHeight(), 0.0f));
        }
    }
}
