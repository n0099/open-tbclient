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
    private BaseActivity fYU;
    private float nUI;
    private a nUD = null;
    private View nUJ = null;
    private BaseWebView mWebView = null;
    private View nUK = null;
    private TextView nUL = null;
    private com.baidu.tbadk.core.view.a nUM = null;
    private c lWe = null;
    private boolean nUN = false;
    private float mRatio = 1.2631578f;
    private Runnable nUO = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.zh(false);
                b.this.dYJ();
            }
        }
    };
    private Runnable icx = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fYU != null) {
                b.this.fYU.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fYU = null;
        if (accountAccessActivity != null) {
            this.fYU = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.nUD = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.nUJ = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.nUJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nUD.dYF();
                b.this.fYU.finish();
            }
        });
        this.nUK = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.nUL = (TextView) this.nUK.findViewById(R.id.custom_loading_text);
        this.nUL.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.lWe = new c();
        this.lWe.toastTime = 1000L;
        this.nUI = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.nUD == null) {
                            return false;
                        }
                        if (!b.this.nUN) {
                            b.this.nUN = true;
                            b.this.zh(false);
                            b.this.dYJ();
                            b.this.nUD.dYE();
                            return true;
                        }
                        return b.this.nUD.VF(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.nUN = true;
                        if (b.this.nUD != null) {
                            b.this.nUD.dYE();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.zh(false);
                        b.this.fYU.showToast(R.string.neterror);
                        b.this.fYU.finish();
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
        if (this.nUK != null) {
            if (z) {
                this.nUK.setVisibility(0);
            } else {
                this.nUK.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mY().removeCallbacks(this.nUO);
        e.mY().removeCallbacks(this.icx);
        this.nUM = null;
    }

    public BaseActivity getContext() {
        return this.fYU;
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
        e.mY().postDelayed(this.nUO, i);
    }

    public void zh(boolean z) {
        if (this.nUM == null) {
            this.nUM = new com.baidu.tbadk.core.view.a(this.fYU.getPageContext());
            this.nUM.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fYU.finish();
                }
            });
        }
        this.nUM.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fYU.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dYH() {
        return this.mRatio;
    }

    public float dYI() {
        return this.nUI;
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

    public void dYJ() {
        if (this.fYU != null) {
            if (this.mRatio == this.nUI) {
                this.mWebView.startAnimation(F(l.getEquipmentHeight(this.fYU.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mY().postDelayed(this.icx, 800L);
                return;
            }
            this.mWebView.startAnimation(F(this.mWebView.getHeight(), 0.0f));
        }
    }
}
