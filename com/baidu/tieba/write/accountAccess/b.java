package com.baidu.tieba.write.accountAccess;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class b {
    private BaseActivity dXV;
    private float kMx;
    private a kMr = null;
    private View kMy = null;
    private BaseWebView mWebView = null;
    private View kMz = null;
    private TextView kMA = null;
    private com.baidu.tbadk.core.view.a kMB = null;
    private d iUs = null;
    private boolean kMC = false;
    private float mRatio = 1.2631578f;
    private Runnable kMD = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.tL(false);
                b.this.cUv();
            }
        }
    };
    private Runnable fCT = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.dXV != null) {
                b.this.dXV.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.dXV = null;
        if (accountAccessActivity != null) {
            this.dXV = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.kMr = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.kMy = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.kMy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kMr.cUs();
                b.this.dXV.finish();
            }
        });
        this.kMz = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.kMA = (TextView) this.kMz.findViewById(R.id.custom_loading_text);
        this.kMA.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.iUs = new d();
        this.iUs.toastTime = 1000L;
        this.kMx = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.kMr == null) {
                            return false;
                        }
                        if (!b.this.kMC) {
                            b.this.kMC = true;
                            b.this.tL(false);
                            b.this.cUv();
                            b.this.kMr.cUr();
                            return true;
                        }
                        return b.this.kMr.KO(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.kMC = true;
                        if (b.this.kMr != null) {
                            b.this.kMr.cUr();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.tL(false);
                        b.this.dXV.showToast(R.string.neterror);
                        b.this.dXV.finish();
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
        if (this.kMz != null) {
            if (z) {
                this.kMz.setVisibility(0);
            } else {
                this.kMz.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.gx().removeCallbacks(this.kMD);
        e.gx().removeCallbacks(this.fCT);
        this.kMB = null;
    }

    public BaseActivity getContext() {
        return this.dXV;
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
        e.gx().postDelayed(this.kMD, i);
    }

    public void tL(boolean z) {
        if (this.kMB == null) {
            this.kMB = new com.baidu.tbadk.core.view.a(this.dXV.getPageContext());
            this.kMB.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.dXV.finish();
                }
            });
        }
        this.kMB.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.dXV.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dT() {
        return this.mRatio;
    }

    public float cUu() {
        return this.kMx;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation z(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void cUv() {
        if (this.dXV != null) {
            if (this.mRatio == this.kMx) {
                this.mWebView.startAnimation(z(l.getEquipmentHeight(this.dXV.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.gx().postDelayed(this.fCT, 800L);
                return;
            }
            this.mWebView.startAnimation(z(this.mWebView.getHeight(), 0.0f));
        }
    }
}
