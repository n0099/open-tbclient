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
/* loaded from: classes8.dex */
public class b {
    private BaseActivity ggh;
    private float odE;
    private a odz = null;
    private View odF = null;
    private BaseWebView mWebView = null;
    private View odG = null;
    private TextView odH = null;
    private com.baidu.tbadk.core.view.a odI = null;
    private c mfQ = null;
    private boolean odJ = false;
    private float mRatio = 1.2631578f;
    private Runnable odK = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.mWebView != null) {
                b.this.zA(false);
                b.this.dWJ();
            }
        }
    };
    private Runnable ipW = new Runnable() { // from class: com.baidu.tieba.write.accountAccess.b.2
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.ggh != null) {
                b.this.ggh.ShowSoftKeyPadDelay(b.this.mWebView);
            }
        }
    };

    public b(AccountAccessActivity accountAccessActivity) {
        this.ggh = null;
        if (accountAccessActivity != null) {
            this.ggh = accountAccessActivity;
            if (!a(accountAccessActivity)) {
                accountAccessActivity.finish();
            }
        }
    }

    public void c(a aVar) {
        this.odz = aVar;
    }

    private boolean a(AccountAccessActivity accountAccessActivity) {
        accountAccessActivity.setActivityBgTransparent();
        accountAccessActivity.setSwipeBackEnabled(false);
        accountAccessActivity.setContentView(R.layout.account_access_activity);
        this.odF = accountAccessActivity.findViewById(R.id.account_access_black_layout);
        this.odF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.accountAccess.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.odz.dWG();
                b.this.ggh.finish();
            }
        });
        this.odG = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
        this.odH = (TextView) this.odG.findViewById(R.id.custom_loading_text);
        this.odH.setText(accountAccessActivity.getResources().getString(R.string.sending));
        this.mfQ = new c();
        this.mfQ.toastTime = 1000L;
        this.odE = l.getEquipmentWidth(accountAccessActivity.getBaseContext()) / l.getEquipmentHeight(accountAccessActivity.getBaseContext());
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.mWebView, this.mRatio);
                this.mWebView.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.accountAccess.b.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str) || b.this.odz == null) {
                            return false;
                        }
                        if (!b.this.odJ) {
                            b.this.odJ = true;
                            b.this.zA(false);
                            b.this.dWJ();
                            b.this.odz.dWF();
                            return true;
                        }
                        return b.this.odz.Va(str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        b.this.odJ = true;
                        if (b.this.odz != null) {
                            b.this.odz.dWF();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        b.this.zA(false);
                        b.this.ggh.showToast(R.string.neterror);
                        b.this.ggh.finish();
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
        if (this.odG != null) {
            if (z) {
                this.odG.setVisibility(0);
            } else {
                this.odG.setVisibility(8);
            }
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void onDestory() {
        e.mA().removeCallbacks(this.odK);
        e.mA().removeCallbacks(this.ipW);
        this.odI = null;
    }

    public BaseActivity getContext() {
        return this.ggh;
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
        e.mA().postDelayed(this.odK, i);
    }

    public void zA(boolean z) {
        if (this.odI == null) {
            this.odI = new com.baidu.tbadk.core.view.a(this.ggh.getPageContext());
            this.odI.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.accountAccess.b.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.ggh.finish();
                }
            });
        }
        this.odI.setDialogVisiable(z);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        UtilHelper.setSupportHeight(this.ggh.getPageContext().getPageActivity(), this.mWebView, f);
    }

    public float getRatio() {
        return this.mRatio;
    }

    public float dWI() {
        return this.odE;
    }

    public void setWebViewMargin(int i, int i2, int i3, int i4) {
        if (this.mWebView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams();
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mWebView.setLayoutParams(marginLayoutParams);
        }
    }

    public Animation G(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, f2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    public void dWJ() {
        if (this.ggh != null) {
            if (this.mRatio == this.odE) {
                this.mWebView.startAnimation(G(l.getEquipmentHeight(this.ggh.getBaseContext()) - (this.mWebView.getWidth() * 1.2631578f), 0.0f));
                e.mA().postDelayed(this.ipW, 800L);
                return;
            }
            this.mWebView.startAnimation(G(this.mWebView.getHeight(), 0.0f));
        }
    }
}
