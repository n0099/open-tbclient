package com.baidu.tieba.write.accountAccess;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity cGU;
    private float jOo;
    private a jOi = null;
    private View jOp = null;
    private BaseWebView mWebView = null;
    private View jOq = null;
    private TextView jOr = null;
    private com.baidu.tbadk.core.view.b jOs = null;
    private e iaV = null;
    private boolean jOt = false;
    private float mRatio = 1.2631578f;
    private Runnable jOu = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.rP(false);
                b.this.cyc();
            }
        }
    };
    private Runnable eGd = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.cGU != null) {
                b.this.cGU.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.cGU = null;
        if (accountAccessActivity != null) {
            this.cGU = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.jOi = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.jOp = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.jOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jOi.cxZ();
                b.this.cGU.finish();
            }
        });
        this.jOq = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.jOr = (TextView) this.jOq.findViewById(R.id.custom_loading_text);
        this.jOr.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.iaV = new e();
        this.iaV.toastTime = 1000L;
        this.jOo = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.jOi == null) {
                            return false;
                        }
                        if (!b.this.jOt) {
                            b.this.jOt = true;
                            b.this.rP(false);
                            b.this.cyc();
                            b.this.jOi.cxY();
                            return true;
                        }
                        return b.this.jOi.Fz(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.jOt = true;
                        if (b.this.jOi != null) {
                            b.this.jOi.cxY();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.rP(false);
                        b.this.cGU.showToast(R.string.neterror);
                        b.this.cGU.finish();
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
        if (this.jOq != null) {
            if (z) {
                this.jOq.setVisibility(0);
            } else {
                this.jOq.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.jOu);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eGd);
        this.jOs = null;
    }

    public BaseActivity getContext() {
        return this.cGU;
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
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.jOu, i);
    }

    public void rP(boolean z) {
        if (this.jOs == null) {
            this.jOs = new com.baidu.tbadk.core.view.b(this.cGU.getPageContext());
            this.jOs.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.cGU.finish();
                }
            });
        }
        this.jOs.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.cGU.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dy() {
        return this.mRatio;
    }

    public float cyb() {
        return this.jOo;
    }

    public void C(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation x(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void cyc() {
        if (this.cGU != null) {
            if (this.mRatio == this.jOo) {
                this.mWebView.startAnimation(x(l.getEquipmentHeight(this.cGU.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.eGd, 800L);
                return;
            }
            this.mWebView.startAnimation(x(this.mWebView.getHeight(), 0.0f));
        }
    }
}
