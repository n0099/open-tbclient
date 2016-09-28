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
    private BaseActivity avO;
    private float gbV;
    private a gbQ = null;
    private View czu = null;
    private BaseWebView mWebView = null;
    private View czv = null;
    private TextView czw = null;
    private com.baidu.tbadk.core.view.a czx = null;
    private com.baidu.tbadk.core.view.h gbW = null;
    private boolean czI = false;
    private float dP = 1.2631578f;
    private Runnable czJ = new d(this);
    private Runnable gbX = new e(this);

    public c(AccountAccessActivity accountAccessActivity) {
        this.avO = null;
        if (accountAccessActivity != null) {
            this.avO = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.gbQ = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(r.h.account_access_activity);
        this.czu = accountAccessActivity.findViewById(r.g.account_access_black_layout);
        this.czu.setOnClickListener(new f(this));
        this.czv = accountAccessActivity.findViewById(r.g.aa_post_thread_loading_view);
        this.czw = (TextView) this.czv.findViewById(r.g.custom_loading_text);
        this.czw.setText(accountAccessActivity.getResources().getString(r.j.sending));
        this.gbW = new com.baidu.tbadk.core.view.h();
        this.gbW.aeT = 1000L;
        this.gbV = k.K(accountAccessActivity.getBaseContext()) / k.L(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(r.g.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.dP);
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
        if (this.czv != null) {
            if (z) {
                this.czv.setVisibility(0);
            } else {
                this.czv.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.czJ);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.gbX);
        this.czx = null;
    }

    public BaseActivity getContext() {
        return this.avO;
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.gbW.c(str);
        } else {
            this.gbW.d(str);
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
        com.baidu.adp.lib.h.h.eG().postDelayed(this.czJ, i);
    }

    public void lI(boolean z) {
        if (this.czx == null) {
            this.czx = new com.baidu.tbadk.core.view.a(this.avO.getPageContext());
            this.czx.c(new h(this));
        }
        this.czx.aF(z);
    }

    public void setRatio(float f) {
        this.dP = f;
        UtilHelper.setSupportHeight(this.avO.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float ad() {
        return this.dP;
    }

    public float brY() {
        return this.gbV;
    }

    public void w(int i, int i2, int i3, int i4) {
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

    public void brZ() {
        if (this.avO != null) {
            if (this.dP == this.gbV) {
                this.mWebView.startAnimation(k(k.L(this.avO.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                com.baidu.adp.lib.h.h.eG().postDelayed(this.gbX, 800L);
                return;
            }
            this.mWebView.startAnimation(k(this.mWebView.getHeight(), 0.0f));
        }
    }
}
