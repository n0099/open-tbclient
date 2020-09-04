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
    private BaseActivity fnx;
    private float mNj;
    private a mNe = null;
    private View mNk = null;
    private BaseWebView mWebView = null;
    private View mNl = null;
    private TextView mNm = null;
    private com.baidu.tbadk.core.view.a mNn = null;
    private c kRA = null;
    private boolean mNo = false;
    private float mRatio = 1.2631578f;
    private Runnable mNp = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.xf(false);
                b.this.dGb();
            }
        }
    };
    private Runnable hcP = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fnx != null) {
                b.this.fnx.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fnx = null;
        if (accountAccessActivity != null) {
            this.fnx = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.mNe = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.mNk = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.mNk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mNe.dFX();
                b.this.fnx.finish();
            }
        });
        this.mNl = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.mNm = (TextView) this.mNl.findViewById(R.id.custom_loading_text);
        this.mNm.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.kRA = new c();
        this.kRA.toastTime = 1000L;
        this.mNj = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.mNe == null) {
                            return false;
                        }
                        if (!b.this.mNo) {
                            b.this.mNo = true;
                            b.this.xf(false);
                            b.this.dGb();
                            b.this.mNe.dFW();
                            return true;
                        }
                        return b.this.mNe.SB(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.mNo = true;
                        if (b.this.mNe != null) {
                            b.this.mNe.dFW();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.xf(false);
                        b.this.fnx.showToast(R.string.neterror);
                        b.this.fnx.finish();
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
        if (this.mNl != null) {
            if (z) {
                this.mNl.setVisibility(0);
            } else {
                this.mNl.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mS().removeCallbacks(this.mNp);
        e.mS().removeCallbacks(this.hcP);
        this.mNn = null;
    }

    public BaseActivity getContext() {
        return this.fnx;
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
        e.mS().postDelayed(this.mNp, i);
    }

    public void xf(boolean z) {
        if (this.mNn == null) {
            this.mNn = new com.baidu.tbadk.core.view.a(this.fnx.getPageContext());
            this.mNn.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fnx.finish();
                }
            });
        }
        this.mNn.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fnx.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dFZ() {
        return this.mRatio;
    }

    public float dGa() {
        return this.mNj;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation C(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void dGb() {
        if (this.fnx != null) {
            if (this.mRatio == this.mNj) {
                this.mWebView.startAnimation(C(l.getEquipmentHeight(this.fnx.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mS().postDelayed(this.hcP, 800L);
                return;
            }
            this.mWebView.startAnimation(C(this.mWebView.getHeight(), 0.0f));
        }
    }
}
