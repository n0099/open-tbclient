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
    private BaseActivity ggm;
    private float oee;
    private a odZ = null;
    private View oef = null;
    private BaseWebView mWebView = null;
    private View oeg = null;
    private TextView oeh = null;
    private com.baidu.tbadk.core.view.a oei = null;
    private c mgf = null;
    private boolean oej = false;
    private float mRatio = 1.2631578f;
    private Runnable oek = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.zA(false);
                b.this.dWR();
            }
        }
    };
    private Runnable iqk = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ggm != null) {
                b.this.ggm.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.ggm = null;
        if (accountAccessActivity != null) {
            this.ggm = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.odZ = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.oef = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.oef.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.odZ.dWO();
                b.this.ggm.finish();
            }
        });
        this.oeg = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.oeh = (TextView) this.oeg.findViewById(R.id.custom_loading_text);
        this.oeh.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.mgf = new c();
        this.mgf.toastTime = 1000L;
        this.oee = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.odZ == null) {
                            return false;
                        }
                        if (!b.this.oej) {
                            b.this.oej = true;
                            b.this.zA(false);
                            b.this.dWR();
                            b.this.odZ.dWN();
                            return true;
                        }
                        return b.this.odZ.Vm(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.oej = true;
                        if (b.this.odZ != null) {
                            b.this.odZ.dWN();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.zA(false);
                        b.this.ggm.showToast(R.string.neterror);
                        b.this.ggm.finish();
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
        if (this.oeg != null) {
            if (z) {
                this.oeg.setVisibility(0);
            } else {
                this.oeg.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mA().removeCallbacks(this.oek);
        e.mA().removeCallbacks(this.iqk);
        this.oei = null;
    }

    public BaseActivity getContext() {
        return this.ggm;
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
        e.mA().postDelayed(this.oek, i);
    }

    public void zA(boolean z) {
        if (this.oei == null) {
            this.oei = new com.baidu.tbadk.core.view.a(this.ggm.getPageContext());
            this.oei.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.ggm.finish();
                }
            });
        }
        this.oei.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.ggm.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float getRatio() {
        return this.mRatio;
    }

    public float dWQ() {
        return this.oee;
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

    public void dWR() {
        if (this.ggm != null) {
            if (this.mRatio == this.oee) {
                this.mWebView.startAnimation(G(l.getEquipmentHeight(this.ggm.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mA().postDelayed(this.iqk, 800L);
                return;
            }
            this.mWebView.startAnimation(G(this.mWebView.getHeight(), 0.0f));
        }
    }
}
