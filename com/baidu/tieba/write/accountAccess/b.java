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
    private BaseActivity fLk;
    private float nzf;
    private a nza = null;
    private View nzg = null;
    private BaseWebView mWebView = null;
    private View nzh = null;
    private TextView nzi = null;
    private com.baidu.tbadk.core.view.a nzj = null;
    private c lBU = null;
    private boolean nzk = false;
    private float mRatio = 1.2631578f;
    private Runnable nzl = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.ym(false);
                b.this.dQP();
            }
        }
    };
    private Runnable hLf = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fLk != null) {
                b.this.fLk.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.fLk = null;
        if (accountAccessActivity != null) {
            this.fLk = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.nza = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.nzg = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.nzg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nza.dQL();
                b.this.fLk.finish();
            }
        });
        this.nzh = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.nzi = (TextView) this.nzh.findViewById(R.id.custom_loading_text);
        this.nzi.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.lBU = new c();
        this.lBU.toastTime = 1000L;
        this.nzf = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.nza == null) {
                            return false;
                        }
                        if (!b.this.nzk) {
                            b.this.nzk = true;
                            b.this.ym(false);
                            b.this.dQP();
                            b.this.nza.dQK();
                            return true;
                        }
                        return b.this.nza.Uo(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.nzk = true;
                        if (b.this.nza != null) {
                            b.this.nza.dQK();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.ym(false);
                        b.this.fLk.showToast(R.string.neterror);
                        b.this.fLk.finish();
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
        if (this.nzh != null) {
            if (z) {
                this.nzh.setVisibility(0);
            } else {
                this.nzh.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mY().removeCallbacks(this.nzl);
        e.mY().removeCallbacks(this.hLf);
        this.nzj = null;
    }

    public BaseActivity getContext() {
        return this.fLk;
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
        e.mY().postDelayed(this.nzl, i);
    }

    public void ym(boolean z) {
        if (this.nzj == null) {
            this.nzj = new com.baidu.tbadk.core.view.a(this.fLk.getPageContext());
            this.nzj.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.fLk.finish();
                }
            });
        }
        this.nzj.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.fLk.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dQN() {
        return this.mRatio;
    }

    public float dQO() {
        return this.nzf;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation F(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void dQP() {
        if (this.fLk != null) {
            if (this.mRatio == this.nzf) {
                this.mWebView.startAnimation(F(l.getEquipmentHeight(this.fLk.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mY().postDelayed(this.hLf, 800L);
                return;
            }
            this.mWebView.startAnimation(F(this.mWebView.getHeight(), 0.0f));
        }
    }
}
