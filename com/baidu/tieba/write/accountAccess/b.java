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
/* loaded from: classes2.dex */
public class b {
    private BaseActivity eNb;
    private float lRe;
    private a lQY = null;
    private View lRf = null;
    private BaseWebView mWebView = null;
    private View lRg = null;
    private TextView lRh = null;
    private com.baidu.tbadk.core.view.a lRi = null;
    private c jYa = null;
    private boolean lRj = false;
    private float mRatio = 1.2631578f;
    private Runnable lRk = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.vq(false);
                b.this.dmD();
            }
        }
    };
    private Runnable gxq = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.eNb != null) {
                b.this.eNb.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.eNb = null;
        if (accountAccessActivity != null) {
            this.eNb = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.lQY = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.lRf = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.lRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lQY.dmz();
                b.this.eNb.finish();
            }
        });
        this.lRg = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.lRh = (TextView) this.lRg.findViewById(R.id.custom_loading_text);
        this.lRh.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.jYa = new c();
        this.jYa.toastTime = 1000L;
        this.lRe = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.lQY == null) {
                            return false;
                        }
                        if (!b.this.lRj) {
                            b.this.lRj = true;
                            b.this.vq(false);
                            b.this.dmD();
                            b.this.lQY.dmy();
                            return true;
                        }
                        return b.this.lQY.Oj(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.lRj = true;
                        if (b.this.lQY != null) {
                            b.this.lQY.dmy();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.vq(false);
                        b.this.eNb.showToast(R.string.neterror);
                        b.this.eNb.finish();
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
        if (this.lRg != null) {
            if (z) {
                this.lRg.setVisibility(0);
            } else {
                this.lRg.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.ld().removeCallbacks(this.lRk);
        e.ld().removeCallbacks(this.gxq);
        this.lRi = null;
    }

    public BaseActivity getContext() {
        return this.eNb;
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
        e.ld().postDelayed(this.lRk, i);
    }

    public void vq(boolean z) {
        if (this.lRi == null) {
            this.lRi = new com.baidu.tbadk.core.view.a(this.eNb.getPageContext());
            this.lRi.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.eNb.finish();
                }
            });
        }
        this.lRi.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.eNb.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dmB() {
        return this.mRatio;
    }

    public float dmC() {
        return this.lRe;
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

    public void dmD() {
        if (this.eNb != null) {
            if (this.mRatio == this.lRe) {
                this.mWebView.startAnimation(y(l.getEquipmentHeight(this.eNb.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.ld().postDelayed(this.gxq, 800L);
                return;
            }
            this.mWebView.startAnimation(y(this.mWebView.getHeight(), 0.0f));
        }
    }
}
