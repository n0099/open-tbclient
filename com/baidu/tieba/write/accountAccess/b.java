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
    private BaseActivity eyB;
    private float lxP;
    private a lxJ = null;
    private View lxQ = null;
    private BaseWebView mWebView = null;
    private View lxR = null;
    private TextView lxS = null;
    private com.baidu.tbadk.core.view.a lxT = null;
    private d jGt = null;
    private boolean lxU = false;
    private float mRatio = 1.2631578f;
    private Runnable lxV = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.uS(false);
                b.this.dfm();
            }
        }
    };
    private Runnable giA = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.eyB != null) {
                b.this.eyB.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.eyB = null;
        if (accountAccessActivity != null) {
            this.eyB = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.lxJ = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.lxQ = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.lxQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lxJ.dfi();
                b.this.eyB.finish();
            }
        });
        this.lxR = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.lxS = (TextView) this.lxR.findViewById(R.id.custom_loading_text);
        this.lxS.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.jGt = new d();
        this.jGt.toastTime = 1000L;
        this.lxP = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.lxJ == null) {
                            return false;
                        }
                        if (!b.this.lxU) {
                            b.this.lxU = true;
                            b.this.uS(false);
                            b.this.dfm();
                            b.this.lxJ.dfh();
                            return true;
                        }
                        return b.this.lxJ.Mw(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.lxU = true;
                        if (b.this.lxJ != null) {
                            b.this.lxJ.dfh();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.uS(false);
                        b.this.eyB.showToast(R.string.neterror);
                        b.this.eyB.finish();
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
        if (this.lxR != null) {
            if (z) {
                this.lxR.setVisibility(0);
            } else {
                this.lxR.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.lb().removeCallbacks(this.lxV);
        e.lb().removeCallbacks(this.giA);
        this.lxT = null;
    }

    public BaseActivity getContext() {
        return this.eyB;
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
        e.lb().postDelayed(this.lxV, i);
    }

    public void uS(boolean z) {
        if (this.lxT == null) {
            this.lxT = new com.baidu.tbadk.core.view.a(this.eyB.getPageContext());
            this.lxT.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.eyB.finish();
                }
            });
        }
        this.lxT.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.eyB.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float dfk() {
        return this.mRatio;
    }

    public float dfl() {
        return this.lxP;
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

    public void dfm() {
        if (this.eyB != null) {
            if (this.mRatio == this.lxP) {
                this.mWebView.startAnimation(y(l.getEquipmentHeight(this.eyB.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.lb().postDelayed(this.giA, 800L);
                return;
            }
            this.mWebView.startAnimation(y(this.mWebView.getHeight(), 0.0f));
        }
    }
}
