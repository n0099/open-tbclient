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
    private BaseActivity fCP;
    private float nmE;
    private a nmz = null;
    private View nmF = null;
    private BaseWebView mWebView = null;
    private View nmG = null;
    private TextView nmH = null;
    private com.baidu.tbadk.core.view.a nmI = null;
    private c lpv = null;
    private boolean nmJ = false;
    private float mRatio = 1.2631578f;
    private Runnable nmK = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.xV(false);
                b.this.dNH();
            }
        }
    };
    private Runnable hyJ = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fCP != null) {
                b.this.fCP.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fCP = null;
        if (accountAccessActivity != null) {
            this.fCP = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.nmz = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.nmF = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.nmF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nmz.dND();
                b.this.fCP.finish();
            }
        });
        this.nmG = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.nmH = (TextView) this.nmG.findViewById(R.id.custom_loading_text);
        this.nmH.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.lpv = new c();
        this.lpv.toastTime = 1000L;
        this.nmE = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.nmz == null) {
                            return false;
                        }
                        if (!b.this.nmJ) {
                            b.this.nmJ = true;
                            b.this.xV(false);
                            b.this.dNH();
                            b.this.nmz.dNC();
                            return true;
                        }
                        return b.this.nmz.TP(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.nmJ = true;
                        if (b.this.nmz != null) {
                            b.this.nmz.dNC();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.xV(false);
                        b.this.fCP.showToast(R.string.neterror);
                        b.this.fCP.finish();
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
        if (this.nmG != null) {
            if (z) {
                this.nmG.setVisibility(0);
            } else {
                this.nmG.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mY().removeCallbacks(this.nmK);
        e.mY().removeCallbacks(this.hyJ);
        this.nmI = null;
    }

    public BaseActivity getContext() {
        return this.fCP;
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
        e.mY().postDelayed(this.nmK, i);
    }

    public void xV(boolean z) {
        if (this.nmI == null) {
            this.nmI = new com.baidu.tbadk.core.view.a(this.fCP.getPageContext());
            this.nmI.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fCP.finish();
                }
            });
        }
        this.nmI.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fCP.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dNF() {
        return this.mRatio;
    }

    public float dNG() {
        return this.nmE;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation E(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void dNH() {
        if (this.fCP != null) {
            if (this.mRatio == this.nmE) {
                this.mWebView.startAnimation(E(l.getEquipmentHeight(this.fCP.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mY().postDelayed(this.hyJ, 800L);
                return;
            }
            this.mWebView.startAnimation(E(this.mWebView.getHeight(), 0.0f));
        }
    }
}
