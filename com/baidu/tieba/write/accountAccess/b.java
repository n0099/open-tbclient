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
    private BaseActivity fRa;
    private float nEZ;
    private a nEU = null;
    private View nFa = null;
    private BaseWebView mWebView = null;
    private View nFb = null;
    private TextView nFc = null;
    private com.baidu.tbadk.core.view.a nFd = null;
    private c lHQ = null;
    private boolean nFe = false;
    private float mRatio = 1.2631578f;
    private Runnable nFf = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.yv(false);
                b.this.dTp();
            }
        }
    };
    private Runnable hRc = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fRa != null) {
                b.this.fRa.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fRa = null;
        if (accountAccessActivity != null) {
            this.fRa = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.nEU = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.nFa = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.nFa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nEU.dTl();
                b.this.fRa.finish();
            }
        });
        this.nFb = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.nFc = (TextView) this.nFb.findViewById(R.id.custom_loading_text);
        this.nFc.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.lHQ = new c();
        this.lHQ.toastTime = 1000L;
        this.nEZ = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.nEU == null) {
                            return false;
                        }
                        if (!b.this.nFe) {
                            b.this.nFe = true;
                            b.this.yv(false);
                            b.this.dTp();
                            b.this.nEU.dTk();
                            return true;
                        }
                        return b.this.nEU.UF(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.nFe = true;
                        if (b.this.nEU != null) {
                            b.this.nEU.dTk();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.yv(false);
                        b.this.fRa.showToast(R.string.neterror);
                        b.this.fRa.finish();
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
        if (this.nFb != null) {
            if (z) {
                this.nFb.setVisibility(0);
            } else {
                this.nFb.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mY().removeCallbacks(this.nFf);
        e.mY().removeCallbacks(this.hRc);
        this.nFd = null;
    }

    public BaseActivity getContext() {
        return this.fRa;
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
        e.mY().postDelayed(this.nFf, i);
    }

    public void yv(boolean z) {
        if (this.nFd == null) {
            this.nFd = new com.baidu.tbadk.core.view.a(this.fRa.getPageContext());
            this.nFd.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fRa.finish();
                }
            });
        }
        this.nFd.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fRa.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dTn() {
        return this.mRatio;
    }

    public float dTo() {
        return this.nEZ;
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

    public void dTp() {
        if (this.fRa != null) {
            if (this.mRatio == this.nEZ) {
                this.mWebView.startAnimation(F(l.getEquipmentHeight(this.fRa.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mY().postDelayed(this.hRc, 800L);
                return;
            }
            this.mWebView.startAnimation(F(this.mWebView.getHeight(), 0.0f));
        }
    }
}
