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
    private BaseActivity awH;
    private float gjA;
    private a gjv = null;
    private View cEE = null;
    private BaseWebView mWebView = null;
    private View cEF = null;
    private TextView cEG = null;
    private com.baidu.tbadk.core.view.a cEH = null;
    private com.baidu.tbadk.core.view.h gjB = null;
    private boolean cES = false;
    private float dQ = 1.2631578f;
    private Runnable cET = new d(this);
    private Runnable gjC = new e(this);

    public c(AccountAccessActivity accountAccessActivity) {
        this.awH = null;
        if (accountAccessActivity != null) {
            this.awH = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.gjv = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(r.h.account_access_activity);
        this.cEE = accountAccessActivity.findViewById(r.g.account_access_black_layout);
        this.cEE.setOnClickListener(new f(this));
        this.cEF = accountAccessActivity.findViewById(r.g.aa_post_thread_loading_view);
        this.cEG = (TextView) this.cEF.findViewById(r.g.custom_loading_text);
        this.cEG.setText(accountAccessActivity.getResources().getString(r.j.sending));
        this.gjB = new com.baidu.tbadk.core.view.h();
        this.gjB.afr = 1000L;
        this.gjA = k.K(accountAccessActivity.getBaseContext()) / k.L(accountAccessActivity.getBaseContext());
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
        if (this.cEF != null) {
            if (z) {
                this.cEF.setVisibility(0);
            } else {
                this.cEF.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.cET);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.gjC);
        this.cEH = null;
    }

    public BaseActivity getContext() {
        return this.awH;
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.gjB.c(str);
        } else {
            this.gjB.d(str);
        }
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
        com.baidu.adp.lib.h.h.eG().postDelayed(this.cET, i);
    }

    public void mh(boolean z) {
        if (this.cEH == null) {
            this.cEH = new com.baidu.tbadk.core.view.a(this.awH.getPageContext());
            this.cEH.c(new h(this));
        }
        this.cEH.aI(z);
    }

    public void setRatio(float f) {
        this.dQ = f;
        UtilHelper.setSupportHeight(this.awH.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float ad() {
        return this.dQ;
    }

    public float but() {
        return this.gjA;
    }

    public void v(int i, int i2, int i3, int i4) {
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

    public void buu() {
        if (this.awH != null) {
            if (this.dQ == this.gjA) {
                this.mWebView.startAnimation(k(k.L(this.awH.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                com.baidu.adp.lib.h.h.eG().postDelayed(this.gjC, 800L);
                return;
            }
            this.mWebView.startAnimation(k(this.mWebView.getHeight(), 0.0f));
        }
    }
}
