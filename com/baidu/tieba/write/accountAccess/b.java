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
    private BaseActivity fqC;
    private float mXg;
    private a mXb = null;
    private View mXh = null;
    private BaseWebView mWebView = null;
    private View mXi = null;
    private TextView mXj = null;
    private com.baidu.tbadk.core.view.a mXk = null;
    private c lad = null;
    private boolean mXl = false;
    private float mRatio = 1.2631578f;
    private Runnable mXm = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.xo(false);
                b.this.dJV();
            }
        }
    };
    private Runnable hjO = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fqC != null) {
                b.this.fqC.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fqC = null;
        if (accountAccessActivity != null) {
            this.fqC = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.mXb = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.mXh = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.mXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mXb.dJR();
                b.this.fqC.finish();
            }
        });
        this.mXi = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.mXj = (TextView) this.mXi.findViewById(R.id.custom_loading_text);
        this.mXj.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.lad = new c();
        this.lad.toastTime = 1000L;
        this.mXg = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.mXb == null) {
                            return false;
                        }
                        if (!b.this.mXl) {
                            b.this.mXl = true;
                            b.this.xo(false);
                            b.this.dJV();
                            b.this.mXb.dJQ();
                            return true;
                        }
                        return b.this.mXb.Tb(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.mXl = true;
                        if (b.this.mXb != null) {
                            b.this.mXb.dJQ();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.xo(false);
                        b.this.fqC.showToast(R.string.neterror);
                        b.this.fqC.finish();
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
        if (this.mXi != null) {
            if (z) {
                this.mXi.setVisibility(0);
            } else {
                this.mXi.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mX().removeCallbacks(this.mXm);
        e.mX().removeCallbacks(this.hjO);
        this.mXk = null;
    }

    public BaseActivity getContext() {
        return this.fqC;
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
        e.mX().postDelayed(this.mXm, i);
    }

    public void xo(boolean z) {
        if (this.mXk == null) {
            this.mXk = new com.baidu.tbadk.core.view.a(this.fqC.getPageContext());
            this.mXk.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fqC.finish();
                }
            });
        }
        this.mXk.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fqC.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dJT() {
        return this.mRatio;
    }

    public float dJU() {
        return this.mXg;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation D(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void dJV() {
        if (this.fqC != null) {
            if (this.mRatio == this.mXg) {
                this.mWebView.startAnimation(D(l.getEquipmentHeight(this.fqC.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mX().postDelayed(this.hjO, 800L);
                return;
            }
            this.mWebView.startAnimation(D(this.mWebView.getHeight(), 0.0f));
        }
    }
}
