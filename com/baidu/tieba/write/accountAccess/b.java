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
    private BaseActivity eXy;
    private float mmB;
    private a mmw = null;
    private View mmC = null;
    private BaseWebView mWebView = null;
    private View mmD = null;
    private TextView mmE = null;
    private com.baidu.tbadk.core.view.a mmF = null;
    private c ksY = null;
    private boolean mmG = false;
    private float mRatio = 1.2631578f;
    private Runnable mmH = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.vK(false);
                b.this.drj();
            }
        }
    };
    private Runnable gKp = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.eXy != null) {
                b.this.eXy.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.eXy = null;
        if (accountAccessActivity != null) {
            this.eXy = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.mmw = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.mmC = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.mmC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mmw.drf();
                b.this.eXy.finish();
            }
        });
        this.mmD = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.mmE = (TextView) this.mmD.findViewById(R.id.custom_loading_text);
        this.mmE.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.ksY = new c();
        this.ksY.toastTime = 1000L;
        this.mmB = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.mmw == null) {
                            return false;
                        }
                        if (!b.this.mmG) {
                            b.this.mmG = true;
                            b.this.vK(false);
                            b.this.drj();
                            b.this.mmw.dre();
                            return true;
                        }
                        return b.this.mmw.OS(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.mmG = true;
                        if (b.this.mmw != null) {
                            b.this.mmw.dre();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.vK(false);
                        b.this.eXy.showToast(R.string.neterror);
                        b.this.eXy.finish();
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
        if (this.mmD != null) {
            if (z) {
                this.mmD.setVisibility(0);
            } else {
                this.mmD.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.lt().removeCallbacks(this.mmH);
        e.lt().removeCallbacks(this.gKp);
        this.mmF = null;
    }

    public BaseActivity getContext() {
        return this.eXy;
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
        e.lt().postDelayed(this.mmH, i);
    }

    public void vK(boolean z) {
        if (this.mmF == null) {
            this.mmF = new com.baidu.tbadk.core.view.a(this.eXy.getPageContext());
            this.mmF.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.eXy.finish();
                }
            });
        }
        this.mmF.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.eXy.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float drh() {
        return this.mRatio;
    }

    public float dri() {
        return this.mmB;
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

    public void drj() {
        if (this.eXy != null) {
            if (this.mRatio == this.mmB) {
                this.mWebView.startAnimation(y(l.getEquipmentHeight(this.eXy.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.lt().postDelayed(this.gKp, 800L);
                return;
            }
            this.mWebView.startAnimation(y(this.mWebView.getHeight(), 0.0f));
        }
    }
}
