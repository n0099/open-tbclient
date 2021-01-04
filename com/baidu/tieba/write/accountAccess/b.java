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
/* loaded from: classes8.dex */
public class b {
    private BaseActivity giB;
    private float nYd;
    private a nXY = null;
    private View nYe = null;
    private BaseWebView mWebView = null;
    private View nYf = null;
    private TextView nYg = null;
    private com.baidu.tbadk.core.view.a nYh = null;
    private c mbt = null;
    private boolean nYi = false;
    private float mRatio = 1.2631578f;
    private Runnable nYj = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.zi(false);
                b.this.dYm();
            }
        }
    };
    private Runnable ioX = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.giB != null) {
                b.this.giB.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.giB = null;
        if (accountAccessActivity != null) {
            this.giB = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.nXY = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.nYe = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.nYe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nXY.dYj();
                b.this.giB.finish();
            }
        });
        this.nYf = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.nYg = (TextView) this.nYf.findViewById(R.id.custom_loading_text);
        this.nYg.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.mbt = new c();
        this.mbt.toastTime = 1000L;
        this.nYd = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.nXY == null) {
                            return false;
                        }
                        if (!b.this.nYi) {
                            b.this.nYi = true;
                            b.this.zi(false);
                            b.this.dYm();
                            b.this.nXY.dYi();
                            return true;
                        }
                        return b.this.nXY.Vk(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.nYi = true;
                        if (b.this.nXY != null) {
                            b.this.nXY.dYi();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.zi(false);
                        b.this.giB.showToast(R.string.neterror);
                        b.this.giB.finish();
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
        if (this.nYf != null) {
            if (z) {
                this.nYf.setVisibility(0);
            } else {
                this.nYf.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mB().removeCallbacks(this.nYj);
        e.mB().removeCallbacks(this.ioX);
        this.nYh = null;
    }

    public BaseActivity getContext() {
        return this.giB;
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
        e.mB().postDelayed(this.nYj, i);
    }

    public void zi(boolean z) {
        if (this.nYh == null) {
            this.nYh = new com.baidu.tbadk.core.view.a(this.giB.getPageContext());
            this.nYh.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.giB.finish();
                }
            });
        }
        this.nYh.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.giB.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float getRatio() {
        return this.mRatio;
    }

    public float dYl() {
        return this.nYd;
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

    public void dYm() {
        if (this.giB != null) {
            if (this.mRatio == this.nYd) {
                this.mWebView.startAnimation(F(l.getEquipmentHeight(this.giB.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mB().postDelayed(this.ioX, 800L);
                return;
            }
            this.mWebView.startAnimation(F(this.mWebView.getHeight(), 0.0f));
        }
    }
}
