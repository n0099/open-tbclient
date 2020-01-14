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
/* loaded from: classes11.dex */
public class b {
    private BaseActivity dTQ;
    private float kLR;
    private a kLL = null;
    private View kLS = null;
    private BaseWebView mWebView = null;
    private View kLT = null;
    private TextView kLU = null;
    private com.baidu.tbadk.core.view.a kLV = null;
    private d iSY = null;
    private boolean kLW = false;
    private float mRatio = 1.2631578f;
    private Runnable kLX = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.tH(false);
                b.this.cTh();
            }
        }
    };
    private Runnable fAv = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.dTQ != null) {
                b.this.dTQ.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.dTQ = null;
        if (accountAccessActivity != null) {
            this.dTQ = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.kLL = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.kLS = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.kLS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kLL.cTe();
                b.this.dTQ.finish();
            }
        });
        this.kLT = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.kLU = (TextView) this.kLT.findViewById(R.id.custom_loading_text);
        this.kLU.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.iSY = new d();
        this.iSY.toastTime = 1000L;
        this.kLR = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.kLL == null) {
                            return false;
                        }
                        if (!b.this.kLW) {
                            b.this.kLW = true;
                            b.this.tH(false);
                            b.this.cTh();
                            b.this.kLL.cTd();
                            return true;
                        }
                        return b.this.kLL.KB(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.kLW = true;
                        if (b.this.kLL != null) {
                            b.this.kLL.cTd();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.tH(false);
                        b.this.dTQ.showToast(R.string.neterror);
                        b.this.dTQ.finish();
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
        if (this.kLT != null) {
            if (z) {
                this.kLT.setVisibility(0);
            } else {
                this.kLT.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.gx().removeCallbacks(this.kLX);
        e.gx().removeCallbacks(this.fAv);
        this.kLV = null;
    }

    public BaseActivity getContext() {
        return this.dTQ;
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
        e.gx().postDelayed(this.kLX, i);
    }

    public void tH(boolean z) {
        if (this.kLV == null) {
            this.kLV = new com.baidu.tbadk.core.view.a(this.dTQ.getPageContext());
            this.kLV.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.dTQ.finish();
                }
            });
        }
        this.kLV.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.dTQ.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dS() {
        return this.mRatio;
    }

    public float cTg() {
        return this.kLR;
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

    public void cTh() {
        if (this.dTQ != null) {
            if (this.mRatio == this.kLR) {
                this.mWebView.startAnimation(z(l.getEquipmentHeight(this.dTQ.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.gx().postDelayed(this.fAv, 800L);
                return;
            }
            this.mWebView.startAnimation(z(this.mWebView.getHeight(), 0.0f));
        }
    }
}
