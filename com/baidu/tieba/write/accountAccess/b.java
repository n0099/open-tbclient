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
/* loaded from: classes10.dex */
public class b {
    private BaseActivity dTH;
    private float kIl;
    private a kIf = null;
    private View kIm = null;
    private BaseWebView mWebView = null;
    private View kIn = null;
    private TextView kIo = null;
    private com.baidu.tbadk.core.view.a kIp = null;
    private d iPu = null;
    private boolean kIq = false;
    private float mRatio = 1.2631578f;
    private Runnable kIr = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.tv(false);
                b.this.cSc();
            }
        }
    };
    private Runnable fxk = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.dTH != null) {
                b.this.dTH.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.dTH = null;
        if (accountAccessActivity != null) {
            this.dTH = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.kIf = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.kIm = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.kIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kIf.cRZ();
                b.this.dTH.finish();
            }
        });
        this.kIn = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.kIo = (TextView) this.kIn.findViewById(R.id.custom_loading_text);
        this.kIo.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.iPu = new d();
        this.iPu.toastTime = 1000L;
        this.kIl = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.kIf == null) {
                            return false;
                        }
                        if (!b.this.kIq) {
                            b.this.kIq = true;
                            b.this.tv(false);
                            b.this.cSc();
                            b.this.kIf.cRY();
                            return true;
                        }
                        return b.this.kIf.Kr(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.kIq = true;
                        if (b.this.kIf != null) {
                            b.this.kIf.cRY();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.tv(false);
                        b.this.dTH.showToast(R.string.neterror);
                        b.this.dTH.finish();
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
        if (this.kIn != null) {
            if (z) {
                this.kIn.setVisibility(0);
            } else {
                this.kIn.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.gy().removeCallbacks(this.kIr);
        e.gy().removeCallbacks(this.fxk);
        this.kIp = null;
    }

    public BaseActivity getContext() {
        return this.dTH;
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
        e.gy().postDelayed(this.kIr, i);
    }

    public void tv(boolean z) {
        if (this.kIp == null) {
            this.kIp = new com.baidu.tbadk.core.view.a(this.dTH.getPageContext());
            this.kIp.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.dTH.finish();
                }
            });
        }
        this.kIp.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.dTH.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dS() {
        return this.mRatio;
    }

    public float cSb() {
        return this.kIl;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation z(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void cSc() {
        if (this.dTH != null) {
            if (this.mRatio == this.kIl) {
                this.mWebView.startAnimation(z(l.getEquipmentHeight(this.dTH.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.gy().postDelayed(this.fxk, 800L);
                return;
            }
            this.mWebView.startAnimation(z(this.mWebView.getHeight(), 0.0f));
        }
    }
}
