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
/* loaded from: classes7.dex */
public class b {
    private BaseActivity gdS;
    private float nTy;
    private a nTt = null;
    private View nTz = null;
    private BaseWebView mWebView = null;
    private View nTA = null;
    private TextView nTB = null;
    private com.baidu.tbadk.core.view.a nTC = null;
    private c lWL = null;
    private boolean nTD = false;
    private float mRatio = 1.2631578f;
    private Runnable nTE = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.ze(false);
                b.this.dUv();
            }
        }
    };
    private Runnable iko = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.gdS != null) {
                b.this.gdS.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.gdS = null;
        if (accountAccessActivity != null) {
            this.gdS = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.nTt = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.nTz = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.nTz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nTt.dUs();
                b.this.gdS.finish();
            }
        });
        this.nTA = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.nTB = (TextView) this.nTA.findViewById(R.id.custom_loading_text);
        this.nTB.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.lWL = new c();
        this.lWL.toastTime = 1000L;
        this.nTy = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.nTt == null) {
                            return false;
                        }
                        if (!b.this.nTD) {
                            b.this.nTD = true;
                            b.this.ze(false);
                            b.this.dUv();
                            b.this.nTt.dUr();
                            return true;
                        }
                        return b.this.nTt.Uc(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.nTD = true;
                        if (b.this.nTt != null) {
                            b.this.nTt.dUr();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.ze(false);
                        b.this.gdS.showToast(R.string.neterror);
                        b.this.gdS.finish();
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
        if (this.nTA != null) {
            if (z) {
                this.nTA.setVisibility(0);
            } else {
                this.nTA.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mB().removeCallbacks(this.nTE);
        e.mB().removeCallbacks(this.iko);
        this.nTC = null;
    }

    public BaseActivity getContext() {
        return this.gdS;
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
        e.mB().postDelayed(this.nTE, i);
    }

    public void ze(boolean z) {
        if (this.nTC == null) {
            this.nTC = new com.baidu.tbadk.core.view.a(this.gdS.getPageContext());
            this.nTC.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.gdS.finish();
                }
            });
        }
        this.nTC.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.gdS.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float getRatio() {
        return this.mRatio;
    }

    public float dUu() {
        return this.nTy;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation G(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void dUv() {
        if (this.gdS != null) {
            if (this.mRatio == this.nTy) {
                this.mWebView.startAnimation(G(l.getEquipmentHeight(this.gdS.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mB().postDelayed(this.iko, 800L);
                return;
            }
            this.mWebView.startAnimation(G(this.mWebView.getHeight(), 0.0f));
        }
    }
}
