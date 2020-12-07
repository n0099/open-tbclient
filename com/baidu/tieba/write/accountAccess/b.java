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
    private BaseActivity fYS;
    private float nUG;
    private a nUB = null;
    private View nUH = null;
    private BaseWebView mWebView = null;
    private View nUI = null;
    private TextView nUJ = null;
    private com.baidu.tbadk.core.view.a nUK = null;
    private c lWc = null;
    private boolean nUL = false;
    private float mRatio = 1.2631578f;
    private Runnable nUM = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.zh(false);
                b.this.dYI();
            }
        }
    };
    private Runnable icv = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fYS != null) {
                b.this.fYS.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fYS = null;
        if (accountAccessActivity != null) {
            this.fYS = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.nUB = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.nUH = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.nUH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nUB.dYE();
                b.this.fYS.finish();
            }
        });
        this.nUI = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.nUJ = (TextView) this.nUI.findViewById(R.id.custom_loading_text);
        this.nUJ.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.lWc = new c();
        this.lWc.toastTime = 1000L;
        this.nUG = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.nUB == null) {
                            return false;
                        }
                        if (!b.this.nUL) {
                            b.this.nUL = true;
                            b.this.zh(false);
                            b.this.dYI();
                            b.this.nUB.dYD();
                            return true;
                        }
                        return b.this.nUB.VF(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.nUL = true;
                        if (b.this.nUB != null) {
                            b.this.nUB.dYD();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.zh(false);
                        b.this.fYS.showToast(R.string.neterror);
                        b.this.fYS.finish();
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
        if (this.nUI != null) {
            if (z) {
                this.nUI.setVisibility(0);
            } else {
                this.nUI.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mY().removeCallbacks(this.nUM);
        e.mY().removeCallbacks(this.icv);
        this.nUK = null;
    }

    public BaseActivity getContext() {
        return this.fYS;
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
        e.mY().postDelayed(this.nUM, i);
    }

    public void zh(boolean z) {
        if (this.nUK == null) {
            this.nUK = new com.baidu.tbadk.core.view.a(this.fYS.getPageContext());
            this.nUK.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fYS.finish();
                }
            });
        }
        this.nUK.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fYS.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dYG() {
        return this.mRatio;
    }

    public float dYH() {
        return this.nUG;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation F(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void dYI() {
        if (this.fYS != null) {
            if (this.mRatio == this.nUG) {
                this.mWebView.startAnimation(F(l.getEquipmentHeight(this.fYS.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mY().postDelayed(this.icv, 800L);
                return;
            }
            this.mWebView.startAnimation(F(this.mWebView.getHeight(), 0.0f));
        }
    }
}
