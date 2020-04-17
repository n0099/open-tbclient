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
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private BaseActivity eyw;
    private float lxL;
    private a lxF = null;
    private View lxM = null;
    private BaseWebView mWebView = null;
    private View lxN = null;
    private TextView lxO = null;
    private com.baidu.tbadk.core.view.a lxP = null;
    private d jGp = null;
    private boolean lxQ = false;
    private float mRatio = 1.2631578f;
    private Runnable lxR = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.uS(false);
                b.this.dfp();
            }
        }
    };
    private Runnable giu = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.eyw != null) {
                b.this.eyw.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.eyw = null;
        if (accountAccessActivity != null) {
            this.eyw = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.lxF = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.lxM = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.lxM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lxF.dfl();
                b.this.eyw.finish();
            }
        });
        this.lxN = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.lxO = (TextView) this.lxN.findViewById(R.id.custom_loading_text);
        this.lxO.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.jGp = new d();
        this.jGp.toastTime = 1000L;
        this.lxL = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.lxF == null) {
                            return false;
                        }
                        if (!b.this.lxQ) {
                            b.this.lxQ = true;
                            b.this.uS(false);
                            b.this.dfp();
                            b.this.lxF.dfk();
                            return true;
                        }
                        return b.this.lxF.Mt(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.lxQ = true;
                        if (b.this.lxF != null) {
                            b.this.lxF.dfk();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.uS(false);
                        b.this.eyw.showToast(R.string.neterror);
                        b.this.eyw.finish();
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
        if (this.lxN != null) {
            if (z) {
                this.lxN.setVisibility(0);
            } else {
                this.lxN.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.lb().removeCallbacks(this.lxR);
        e.lb().removeCallbacks(this.giu);
        this.lxP = null;
    }

    public BaseActivity getContext() {
        return this.eyw;
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
        e.lb().postDelayed(this.lxR, i);
    }

    public void uS(boolean z) {
        if (this.lxP == null) {
            this.lxP = new com.baidu.tbadk.core.view.a(this.eyw.getPageContext());
            this.lxP.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.eyw.finish();
                }
            });
        }
        this.lxP.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.eyw.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dfn() {
        return this.mRatio;
    }

    public float dfo() {
        return this.lxL;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation y(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void dfp() {
        if (this.eyw != null) {
            if (this.mRatio == this.lxL) {
                this.mWebView.startAnimation(y(l.getEquipmentHeight(this.eyw.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.lb().postDelayed(this.giu, 800L);
                return;
            }
            this.mWebView.startAnimation(y(this.mWebView.getHeight(), 0.0f));
        }
    }
}
