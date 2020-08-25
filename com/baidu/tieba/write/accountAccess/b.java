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
    private BaseActivity fnt;
    private float mMR;
    private a mMM = null;
    private View mMS = null;
    private BaseWebView mWebView = null;
    private View mMT = null;
    private TextView mMU = null;
    private com.baidu.tbadk.core.view.a mMV = null;
    private c kRt = null;
    private boolean mMW = false;
    private float mRatio = 1.2631578f;
    private Runnable mMX = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.xd(false);
                b.this.dFS();
            }
        }
    };
    private Runnable hcL = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fnt != null) {
                b.this.fnt.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fnt = null;
        if (accountAccessActivity != null) {
            this.fnt = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.mMM = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.mMS = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.mMS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mMM.dFO();
                b.this.fnt.finish();
            }
        });
        this.mMT = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.mMU = (TextView) this.mMT.findViewById(R.id.custom_loading_text);
        this.mMU.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.kRt = new c();
        this.kRt.toastTime = 1000L;
        this.mMR = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.mMM == null) {
                            return false;
                        }
                        if (!b.this.mMW) {
                            b.this.mMW = true;
                            b.this.xd(false);
                            b.this.dFS();
                            b.this.mMM.dFN();
                            return true;
                        }
                        return b.this.mMM.SB(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.mMW = true;
                        if (b.this.mMM != null) {
                            b.this.mMM.dFN();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.xd(false);
                        b.this.fnt.showToast(R.string.neterror);
                        b.this.fnt.finish();
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
        if (this.mMT != null) {
            if (z) {
                this.mMT.setVisibility(0);
            } else {
                this.mMT.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mS().removeCallbacks(this.mMX);
        e.mS().removeCallbacks(this.hcL);
        this.mMV = null;
    }

    public BaseActivity getContext() {
        return this.fnt;
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
        e.mS().postDelayed(this.mMX, i);
    }

    public void xd(boolean z) {
        if (this.mMV == null) {
            this.mMV = new com.baidu.tbadk.core.view.a(this.fnt.getPageContext());
            this.mMV.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fnt.finish();
                }
            });
        }
        this.mMV.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fnt.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dFQ() {
        return this.mRatio;
    }

    public float dFR() {
        return this.mMR;
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

    public void dFS() {
        if (this.fnt != null) {
            if (this.mRatio == this.mMR) {
                this.mWebView.startAnimation(C(l.getEquipmentHeight(this.fnt.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mS().postDelayed(this.hcL, 800L);
                return;
            }
            this.mWebView.startAnimation(C(this.mWebView.getHeight(), 0.0f));
        }
    }
}
