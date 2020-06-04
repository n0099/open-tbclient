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
    private BaseActivity eNm;
    private float lSp;
    private a lSk = null;
    private View lSq = null;
    private BaseWebView mWebView = null;
    private View lSr = null;
    private TextView lSs = null;
    private com.baidu.tbadk.core.view.a lSt = null;
    private c jZg = null;
    private boolean lSu = false;
    private float mRatio = 1.2631578f;
    private Runnable lSv = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.vs(false);
                b.this.dmT();
            }
        }
    };
    private Runnable gxB = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.eNm != null) {
                b.this.eNm.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.eNm = null;
        if (accountAccessActivity != null) {
            this.eNm = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.lSk = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.lSq = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.lSq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lSk.dmP();
                b.this.eNm.finish();
            }
        });
        this.lSr = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.lSs = (TextView) this.lSr.findViewById(R.id.custom_loading_text);
        this.lSs.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.jZg = new c();
        this.jZg.toastTime = 1000L;
        this.lSp = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.lSk == null) {
                            return false;
                        }
                        if (!b.this.lSu) {
                            b.this.lSu = true;
                            b.this.vs(false);
                            b.this.dmT();
                            b.this.lSk.dmO();
                            return true;
                        }
                        return b.this.lSk.Ok(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.lSu = true;
                        if (b.this.lSk != null) {
                            b.this.lSk.dmO();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.vs(false);
                        b.this.eNm.showToast(R.string.neterror);
                        b.this.eNm.finish();
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
        if (this.lSr != null) {
            if (z) {
                this.lSr.setVisibility(0);
            } else {
                this.lSr.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.ld().removeCallbacks(this.lSv);
        e.ld().removeCallbacks(this.gxB);
        this.lSt = null;
    }

    public BaseActivity getContext() {
        return this.eNm;
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
        e.ld().postDelayed(this.lSv, i);
    }

    public void vs(boolean z) {
        if (this.lSt == null) {
            this.lSt = new com.baidu.tbadk.core.view.a(this.eNm.getPageContext());
            this.lSt.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.eNm.finish();
                }
            });
        }
        this.lSt.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.eNm.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dmR() {
        return this.mRatio;
    }

    public float dmS() {
        return this.lSp;
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

    public void dmT() {
        if (this.eNm != null) {
            if (this.mRatio == this.lSp) {
                this.mWebView.startAnimation(y(l.getEquipmentHeight(this.eNm.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.ld().postDelayed(this.gxB, 800L);
                return;
            }
            this.mWebView.startAnimation(y(this.mWebView.getHeight(), 0.0f));
        }
    }
}
