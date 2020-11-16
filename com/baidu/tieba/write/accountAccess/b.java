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
    private BaseActivity fQJ;
    private float nGA;
    private a nGv = null;
    private View nGB = null;
    private BaseWebView mWebView = null;
    private View nGC = null;
    private TextView nGD = null;
    private com.baidu.tbadk.core.view.a nGE = null;
    private c lIi = null;
    private boolean nGF = false;
    private float mRatio = 1.2631578f;
    private Runnable nGG = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.yC(false);
                b.this.dTo();
            }
        }
    };
    private Runnable hRC = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fQJ != null) {
                b.this.fQJ.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fQJ = null;
        if (accountAccessActivity != null) {
            this.fQJ = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.nGv = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.nGB = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.nGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nGv.dTk();
                b.this.fQJ.finish();
            }
        });
        this.nGC = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.nGD = (TextView) this.nGC.findViewById(R.id.custom_loading_text);
        this.nGD.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.lIi = new c();
        this.lIi.toastTime = 1000L;
        this.nGA = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.nGv == null) {
                            return false;
                        }
                        if (!b.this.nGF) {
                            b.this.nGF = true;
                            b.this.yC(false);
                            b.this.dTo();
                            b.this.nGv.dTj();
                            return true;
                        }
                        return b.this.nGv.Uq(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.nGF = true;
                        if (b.this.nGv != null) {
                            b.this.nGv.dTj();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.yC(false);
                        b.this.fQJ.showToast(R.string.neterror);
                        b.this.fQJ.finish();
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
        if (this.nGC != null) {
            if (z) {
                this.nGC.setVisibility(0);
            } else {
                this.nGC.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mY().removeCallbacks(this.nGG);
        e.mY().removeCallbacks(this.hRC);
        this.nGE = null;
    }

    public BaseActivity getContext() {
        return this.fQJ;
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
        e.mY().postDelayed(this.nGG, i);
    }

    public void yC(boolean z) {
        if (this.nGE == null) {
            this.nGE = new com.baidu.tbadk.core.view.a(this.fQJ.getPageContext());
            this.nGE.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fQJ.finish();
                }
            });
        }
        this.nGE.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fQJ.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dTm() {
        return this.mRatio;
    }

    public float dTn() {
        return this.nGA;
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

    public void dTo() {
        if (this.fQJ != null) {
            if (this.mRatio == this.nGA) {
                this.mWebView.startAnimation(F(l.getEquipmentHeight(this.fQJ.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mY().postDelayed(this.hRC, 800L);
                return;
            }
            this.mWebView.startAnimation(F(this.mWebView.getHeight(), 0.0f));
        }
    }
}
