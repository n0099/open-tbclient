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
/* loaded from: classes13.dex */
public class b {
    private BaseActivity dYz;
    private float kOu;
    private a kOo = null;
    private View kOv = null;
    private BaseWebView mWebView = null;
    private View kOw = null;
    private TextView kOx = null;
    private com.baidu.tbadk.core.view.a kOy = null;
    private d iWh = null;
    private boolean kOz = false;
    private float mRatio = 1.2631578f;
    private Runnable kOA = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.tS(false);
                b.this.cUT();
            }
        }
    };
    private Runnable fDQ = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.dYz != null) {
                b.this.dYz.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.dYz = null;
        if (accountAccessActivity != null) {
            this.dYz = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.kOo = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.kOv = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.kOv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kOo.cUQ();
                b.this.dYz.finish();
            }
        });
        this.kOw = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.kOx = (TextView) this.kOw.findViewById(R.id.custom_loading_text);
        this.kOx.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.iWh = new d();
        this.iWh.toastTime = 1000L;
        this.kOu = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.kOo == null) {
                            return false;
                        }
                        if (!b.this.kOz) {
                            b.this.kOz = true;
                            b.this.tS(false);
                            b.this.cUT();
                            b.this.kOo.cUP();
                            return true;
                        }
                        return b.this.kOo.KP(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.kOz = true;
                        if (b.this.kOo != null) {
                            b.this.kOo.cUP();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.tS(false);
                        b.this.dYz.showToast(R.string.neterror);
                        b.this.dYz.finish();
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
        if (this.kOw != null) {
            if (z) {
                this.kOw.setVisibility(0);
            } else {
                this.kOw.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.gx().removeCallbacks(this.kOA);
        e.gx().removeCallbacks(this.fDQ);
        this.kOy = null;
    }

    public BaseActivity getContext() {
        return this.dYz;
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
        e.gx().postDelayed(this.kOA, i);
    }

    public void tS(boolean z) {
        if (this.kOy == null) {
            this.kOy = new com.baidu.tbadk.core.view.a(this.dYz.getPageContext());
            this.kOy.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.dYz.finish();
                }
            });
        }
        this.kOy.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.dYz.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dT() {
        return this.mRatio;
    }

    public float cUS() {
        return this.kOu;
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

    public void cUT() {
        if (this.dYz != null) {
            if (this.mRatio == this.kOu) {
                this.mWebView.startAnimation(z(l.getEquipmentHeight(this.dYz.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.gx().postDelayed(this.fDQ, 800L);
                return;
            }
            this.mWebView.startAnimation(z(this.mWebView.getHeight(), 0.0f));
        }
    }
}
