package com.baidu.tieba.write.vcode.newVcode;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import d.a.m0.r.f0.a;
import d.a.m0.r.f0.c;
import d.a.n0.w3.s.a.a.b;
/* loaded from: classes5.dex */
public class NewVcodeView {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f21870a;

    /* renamed from: b  reason: collision with root package name */
    public b f21871b;

    /* renamed from: c  reason: collision with root package name */
    public BaseWebView f21872c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f21873d = null;

    /* renamed from: e  reason: collision with root package name */
    public View f21874e = null;

    /* renamed from: f  reason: collision with root package name */
    public a f21875f = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21876g = null;

    /* renamed from: h  reason: collision with root package name */
    public c f21877h = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21878i = false;
    public Runnable j = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.f21872c != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };
    public float k;

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.f21870a = newVcodeActivity;
        if (initUI(newVcodeActivity)) {
            return;
        }
        newVcodeActivity.finish();
    }

    @JavascriptInterface
    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean initUI(NewVcodeActivity newVcodeActivity) {
        newVcodeActivity.setActivityBgTransparent();
        newVcodeActivity.setSwipeBackEnabled(false);
        newVcodeActivity.setContentView(R.layout.new_vcode_activity);
        View findViewById = newVcodeActivity.findViewById(R.id.new_vcode_black_layout);
        this.f21873d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.f21871b.d();
                NewVcodeView.this.f21870a.finish();
            }
        });
        View findViewById2 = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.f21874e = findViewById2;
        TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
        this.f21876g = textView;
        textView.setText(newVcodeActivity.getResources().getString(R.string.sending));
        c cVar = new c();
        this.f21877h = cVar;
        cVar.f49709a = 1000L;
        if (this.f21872c == null) {
            try {
                this.f21872c = (BaseWebView) newVcodeActivity.findViewById(R.id.new_vcode_webview);
                UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.f21872c, 1.2631578f);
                this.f21872c.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.f21872c.setInitialScale(100);
                this.f21872c.getSettings().setJavaScriptEnabled(true);
                this.f21872c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f21872c.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.f21878i = true;
                        if (NewVcodeView.this.f21871b != null) {
                            NewVcodeView.this.f21871b.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i2, String str, String str2) {
                        super.onReceivedError(webView, i2, str, str2);
                        NewVcodeView.this.h(false);
                        NewVcodeView.this.f21870a.showToast(R.string.neterror);
                        NewVcodeView.this.f21870a.finish();
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str)) {
                            return false;
                        }
                        if (!NewVcodeView.this.f21878i) {
                            NewVcodeView.this.f21878i = true;
                            e.a().postDelayed(NewVcodeView.this.j, 500L);
                            if (NewVcodeView.this.f21871b != null) {
                                NewVcodeView.this.f21871b.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.f21871b == null) {
                            return false;
                        }
                        return NewVcodeView.this.f21871b.b(webView, str);
                    }
                });
                return true;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    public BaseActivity getContext() {
        return this.f21870a;
    }

    public WebView getWebView() {
        return this.f21872c;
    }

    public final void h(boolean z) {
        if (this.f21875f == null) {
            a aVar = new a(this.f21870a.getPageContext());
            this.f21875f = aVar;
            aVar.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.f21870a.finish();
                }
            });
        }
        this.f21875f.h(z);
    }

    public void onDestory() {
        e.a().removeCallbacks(this.j);
    }

    public void runJsMethod(String str, String str2) {
        if (this.f21872c != null) {
            this.f21872c.loadUrl("javascript:window." + str + "(" + str2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void setPresenter(b bVar) {
        this.f21871b = bVar;
        this.f21878i = false;
    }

    public void setRatio(float f2) {
        this.k = f2;
    }

    public void showPostThreadLoadingView(boolean z) {
        View view = this.f21874e;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void showToast(boolean z, String str) {
        if (z) {
            this.f21877h.c(str);
        } else {
            this.f21877h.b(str);
        }
    }

    public void showWebView(boolean z) {
        h(!z);
        BaseWebView baseWebView = this.f21872c;
        if (baseWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.f21870a.getPageContext().getPageActivity(), this.f21872c, this.k);
                this.f21872c.setVisibility(0);
                return;
            }
            baseWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i2) {
        e.a().postDelayed(this.j, i2);
    }
}
