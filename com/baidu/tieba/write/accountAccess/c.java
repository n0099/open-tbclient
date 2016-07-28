package com.baidu.tieba.write.accountAccess;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c {
    private BaseActivity ate;
    private float fPH;
    private a fPC = null;
    private View cnH = null;
    private BaseWebView mWebView = null;
    private View cnI = null;
    private TextView cnJ = null;
    private com.baidu.tbadk.core.view.b cnK = null;
    private com.baidu.tbadk.core.view.h fPI = null;
    private boolean cnV = false;
    private float fPJ = 1.2631578f;
    private Runnable cnW = new d(this);
    private Runnable fPK = new e(this);

    public c(AccountAccessActivity accountAccessActivity) {
        this.ate = null;
        if (accountAccessActivity != null) {
            this.ate = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.fPC = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(u.h.account_access_activity);
        this.cnH = accountAccessActivity.findViewById(u.g.account_access_black_layout);
        this.cnH.setOnClickListener(new f(this));
        this.cnI = accountAccessActivity.findViewById(u.g.aa_post_thread_loading_view);
        this.cnJ = (TextView) this.cnI.findViewById(u.g.custom_loading_text);
        this.cnJ.setText(accountAccessActivity.getResources().getString(u.j.sending));
        this.fPI = new com.baidu.tbadk.core.view.h();
        this.fPI.abS = 1000L;
        this.fPH = k.A(accountAccessActivity.getBaseContext()) / k.B(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(u.g.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.fPJ);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.setWebViewClient(new g(this));
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TbadkCoreApplication.m10getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m10getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    public void showPostThreadLoadingView(boolean z) {
        if (this.cnI != null) {
            if (z) {
                this.cnI.setVisibility(0);
            } else {
                this.cnI.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.cnW);
        this.cnK = null;
    }

    public BaseActivity getContext() {
        return this.ate;
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.fPI.c(str);
        } else {
            this.fPI.d(str);
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
        com.baidu.adp.lib.h.h.dL().postDelayed(this.cnW, i);
    }

    public void lq(boolean z) {
        if (this.cnK == null) {
            this.cnK = new com.baidu.tbadk.core.view.b(this.ate.getPageContext());
            this.cnK.c(new h(this));
        }
        this.cnK.aE(z);
    }

    public void setRatio(float f) {
        this.fPJ = f;
        UtilHelper.setSupportHeight(this.ate.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float bnb() {
        return this.fPJ;
    }

    public float bnc() {
        return this.fPH;
    }

    public void u(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public static void m(View view, float f) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setDuration(300L);
        animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, f, 0.0f));
        view.startAnimation(animationSet);
    }

    public void bnd() {
        if (this.ate != null) {
            if (this.fPJ == this.fPH) {
                m(this.mWebView, (k.B(this.ate.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f)) - UtilHelper.getImmersiveStickyBarHeight());
                com.baidu.adp.lib.h.h.dL().postDelayed(this.fPK, 800L);
                return;
            }
            m(this.mWebView, this.mWebView.getHeight());
        }
    }
}
