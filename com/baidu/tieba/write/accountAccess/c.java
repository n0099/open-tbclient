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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    private BaseActivity awl;
    private float fZM;
    private a fZH = null;
    private View cyQ = null;
    private BaseWebView mWebView = null;
    private View cyR = null;
    private TextView cyS = null;
    private com.baidu.tbadk.core.view.a cyT = null;
    private com.baidu.tbadk.core.view.h fZN = null;
    private boolean cze = false;
    private float dP = 1.2631578f;
    private Runnable czf = new d(this);
    private Runnable fZO = new e(this);

    public c(AccountAccessActivity accountAccessActivity) {
        this.awl = null;
        if (accountAccessActivity != null) {
            this.awl = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.fZH = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(t.h.account_access_activity);
        this.cyQ = accountAccessActivity.findViewById(t.g.account_access_black_layout);
        this.cyQ.setOnClickListener(new f(this));
        this.cyR = accountAccessActivity.findViewById(t.g.aa_post_thread_loading_view);
        this.cyS = (TextView) this.cyR.findViewById(t.g.custom_loading_text);
        this.cyS.setText(accountAccessActivity.getResources().getString(t.j.sending));
        this.fZN = new com.baidu.tbadk.core.view.h();
        this.fZN.aeI = 1000L;
        this.fZM = k.K(accountAccessActivity.getBaseContext()) / k.L(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(t.g.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.dP);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.getSettings().setJavaScriptEnabled(true);
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
        if (this.cyR != null) {
            if (z) {
                this.cyR.setVisibility(0);
            } else {
                this.cyR.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.czf);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fZO);
        this.cyT = null;
    }

    public BaseActivity getContext() {
        return this.awl;
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.fZN.c(str);
        } else {
            this.fZN.d(str);
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
        com.baidu.adp.lib.h.h.eG().postDelayed(this.czf, i);
    }

    public void lG(boolean z) {
        if (this.cyT == null) {
            this.cyT = new com.baidu.tbadk.core.view.a(this.awl.getPageContext());
            this.cyT.c(new h(this));
        }
        this.cyT.aF(z);
    }

    public void setRatio(float f) {
        this.dP = f;
        UtilHelper.setSupportHeight(this.awl.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float ad() {
        return this.dP;
    }

    public float brs() {
        return this.fZM;
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

    public void brt() {
        if (this.awl != null) {
            if (this.dP == this.fZM) {
                this.mWebView.startAnimation(k(k.L(this.awl.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                com.baidu.adp.lib.h.h.eG().postDelayed(this.fZO, 800L);
                return;
            }
            this.mWebView.startAnimation(k(this.mWebView.getHeight(), 0.0f));
        }
    }
}
