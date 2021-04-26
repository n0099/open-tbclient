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
import d.a.i0.r.f0.a;
import d.a.i0.r.f0.c;
import d.a.j0.v3.s.a.a.b;
/* loaded from: classes5.dex */
public class NewVcodeView {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f22697a;

    /* renamed from: b  reason: collision with root package name */
    public b f22698b;

    /* renamed from: c  reason: collision with root package name */
    public BaseWebView f22699c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f22700d = null;

    /* renamed from: e  reason: collision with root package name */
    public View f22701e = null;

    /* renamed from: f  reason: collision with root package name */
    public a f22702f = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22703g = null;

    /* renamed from: h  reason: collision with root package name */
    public c f22704h = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22705i = false;
    public Runnable j = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.f22699c != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };
    public float k;

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.f22697a = newVcodeActivity;
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
        this.f22700d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.f22698b.d();
                NewVcodeView.this.f22697a.finish();
            }
        });
        View findViewById2 = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.f22701e = findViewById2;
        TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
        this.f22703g = textView;
        textView.setText(newVcodeActivity.getResources().getString(R.string.sending));
        c cVar = new c();
        this.f22704h = cVar;
        cVar.f48836a = 1000L;
        if (this.f22699c == null) {
            try {
                this.f22699c = (BaseWebView) newVcodeActivity.findViewById(R.id.new_vcode_webview);
                UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.f22699c, 1.2631578f);
                this.f22699c.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.f22699c.setInitialScale(100);
                this.f22699c.getSettings().setJavaScriptEnabled(true);
                this.f22699c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f22699c.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.f22705i = true;
                        if (NewVcodeView.this.f22698b != null) {
                            NewVcodeView.this.f22698b.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i2, String str, String str2) {
                        super.onReceivedError(webView, i2, str, str2);
                        NewVcodeView.this.h(false);
                        NewVcodeView.this.f22697a.showToast(R.string.neterror);
                        NewVcodeView.this.f22697a.finish();
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str)) {
                            return false;
                        }
                        if (!NewVcodeView.this.f22705i) {
                            NewVcodeView.this.f22705i = true;
                            e.a().postDelayed(NewVcodeView.this.j, 500L);
                            if (NewVcodeView.this.f22698b != null) {
                                NewVcodeView.this.f22698b.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.f22698b == null) {
                            return false;
                        }
                        return NewVcodeView.this.f22698b.b(webView, str);
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
        return this.f22697a;
    }

    public WebView getWebView() {
        return this.f22699c;
    }

    public final void h(boolean z) {
        if (this.f22702f == null) {
            a aVar = new a(this.f22697a.getPageContext());
            this.f22702f = aVar;
            aVar.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.f22697a.finish();
                }
            });
        }
        this.f22702f.h(z);
    }

    public void onDestory() {
        e.a().removeCallbacks(this.j);
    }

    public void runJsMethod(String str, String str2) {
        if (this.f22699c != null) {
            this.f22699c.loadUrl("javascript:window." + str + "(" + str2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void setPresenter(b bVar) {
        this.f22698b = bVar;
        this.f22705i = false;
    }

    public void setRatio(float f2) {
        this.k = f2;
    }

    public void showPostThreadLoadingView(boolean z) {
        View view = this.f22701e;
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
            this.f22704h.c(str);
        } else {
            this.f22704h.b(str);
        }
    }

    public void showWebView(boolean z) {
        h(!z);
        BaseWebView baseWebView = this.f22699c;
        if (baseWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.f22697a.getPageContext().getPageActivity(), this.f22699c, this.k);
                this.f22699c.setVisibility(0);
                return;
            }
            baseWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i2) {
        e.a().postDelayed(this.j, i2);
    }
}
