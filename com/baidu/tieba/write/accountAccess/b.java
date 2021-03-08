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
    private BaseActivity ghP;
    private float ogk;
    private a ogf = null;
    private View ogl = null;
    private BaseWebView mWebView = null;
    private View ogm = null;
    private TextView ogn = null;
    private com.baidu.tbadk.core.view.a ogo = null;
    private c mii = null;
    private boolean ogp = false;
    private float mRatio = 1.2631578f;
    private Runnable ogq = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.zz(false);
                b.this.dWZ();
            }
        }
    };
    private Runnable irT = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ghP != null) {
                b.this.ghP.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.ghP = null;
        if (accountAccessActivity != null) {
            this.ghP = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.ogf = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.ogl = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.ogl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ogf.dWW();
                b.this.ghP.finish();
            }
        });
        this.ogm = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.ogn = (TextView) this.ogm.findViewById(R.id.custom_loading_text);
        this.ogn.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.mii = new c();
        this.mii.toastTime = 1000L;
        this.ogk = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.ogf == null) {
                            return false;
                        }
                        if (!b.this.ogp) {
                            b.this.ogp = true;
                            b.this.zz(false);
                            b.this.dWZ();
                            b.this.ogf.dWV();
                            return true;
                        }
                        return b.this.ogf.Vt(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.ogp = true;
                        if (b.this.ogf != null) {
                            b.this.ogf.dWV();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.zz(false);
                        b.this.ghP.showToast(R.string.neterror);
                        b.this.ghP.finish();
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
        if (this.ogm != null) {
            if (z) {
                this.ogm.setVisibility(0);
            } else {
                this.ogm.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mA().removeCallbacks(this.ogq);
        e.mA().removeCallbacks(this.irT);
        this.ogo = null;
    }

    public BaseActivity getContext() {
        return this.ghP;
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
        e.mA().postDelayed(this.ogq, i);
    }

    public void zz(boolean z) {
        if (this.ogo == null) {
            this.ogo = new com.baidu.tbadk.core.view.a(this.ghP.getPageContext());
            this.ogo.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.ghP.finish();
                }
            });
        }
        this.ogo.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.ghP.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float getRatio() {
        return this.mRatio;
    }

    public float dWY() {
        return this.ogk;
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

    public void dWZ() {
        if (this.ghP != null) {
            if (this.mRatio == this.ogk) {
                this.mWebView.startAnimation(G(l.getEquipmentHeight(this.ghP.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mA().postDelayed(this.irT, 800L);
                return;
            }
            this.mWebView.startAnimation(G(this.mWebView.getHeight(), 0.0f));
        }
    }
}
