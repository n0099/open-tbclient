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
import com.baidu.tbadk.core.view.c;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity fbZ;
    private float muB;
    private a muw = null;
    private View muC = null;
    private BaseWebView mWebView = null;
    private View muD = null;
    private TextView muE = null;
    private com.baidu.tbadk.core.view.a muF = null;
    private c kBM = null;
    private boolean muG = false;
    private float mRatio = 1.2631578f;
    private Runnable muH = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.wo(false);
                b.this.duv();
            }
        }
    };
    private Runnable gPV = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fbZ != null) {
                b.this.fbZ.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fbZ = null;
        if (accountAccessActivity != null) {
            this.fbZ = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.muw = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.muC = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.muC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.muw.dur();
                b.this.fbZ.finish();
            }
        });
        this.muD = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.muE = (TextView) this.muD.findViewById(R.id.custom_loading_text);
        this.muE.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.kBM = new c();
        this.kBM.toastTime = 1000L;
        this.muB = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.muw == null) {
                            return false;
                        }
                        if (!b.this.muG) {
                            b.this.muG = true;
                            b.this.wo(false);
                            b.this.duv();
                            b.this.muw.duq();
                            return true;
                        }
                        return b.this.muw.PD(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.muG = true;
                        if (b.this.muw != null) {
                            b.this.muw.duq();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.wo(false);
                        b.this.fbZ.showToast(R.string.neterror);
                        b.this.fbZ.finish();
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
        if (this.muD != null) {
            if (z) {
                this.muD.setVisibility(0);
            } else {
                this.muD.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.lt().removeCallbacks(this.muH);
        e.lt().removeCallbacks(this.gPV);
        this.muF = null;
    }

    public BaseActivity getContext() {
        return this.fbZ;
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
        e.lt().postDelayed(this.muH, i);
    }

    public void wo(boolean z) {
        if (this.muF == null) {
            this.muF = new com.baidu.tbadk.core.view.a(this.fbZ.getPageContext());
            this.muF.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fbZ.finish();
                }
            });
        }
        this.muF.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fbZ.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dut() {
        return this.mRatio;
    }

    public float duu() {
        return this.muB;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation y(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void duv() {
        if (this.fbZ != null) {
            if (this.mRatio == this.muB) {
                this.mWebView.startAnimation(y(l.getEquipmentHeight(this.fbZ.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.lt().postDelayed(this.gPV, 800L);
                return;
            }
            this.mWebView.startAnimation(y(this.mWebView.getHeight(), 0.0f));
        }
    }
}
