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
import d.b.b.e.m.e;
import d.b.h0.r.f0.a;
import d.b.h0.r.f0.c;
import d.b.i0.u3.t.a.a.b;
/* loaded from: classes5.dex */
public class NewVcodeView {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f22325a;

    /* renamed from: b  reason: collision with root package name */
    public b f22326b;

    /* renamed from: c  reason: collision with root package name */
    public BaseWebView f22327c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f22328d = null;

    /* renamed from: e  reason: collision with root package name */
    public View f22329e = null;

    /* renamed from: f  reason: collision with root package name */
    public a f22330f = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22331g = null;

    /* renamed from: h  reason: collision with root package name */
    public c f22332h = null;
    public boolean i = false;
    public Runnable j = new Runnable() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeView.this.f22327c != null) {
                NewVcodeView.this.showWebView(true);
            }
        }
    };
    public float k;

    public NewVcodeView(NewVcodeActivity newVcodeActivity) {
        this.f22325a = newVcodeActivity;
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
        this.f22328d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeView.this.f22326b.d();
                NewVcodeView.this.f22325a.finish();
            }
        });
        View findViewById2 = newVcodeActivity.findViewById(R.id.post_thread_loading_view);
        this.f22329e = findViewById2;
        TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
        this.f22331g = textView;
        textView.setText(newVcodeActivity.getResources().getString(R.string.sending));
        c cVar = new c();
        this.f22332h = cVar;
        cVar.f50484a = 1000L;
        if (this.f22327c == null) {
            try {
                this.f22327c = (BaseWebView) newVcodeActivity.findViewById(R.id.new_vcode_webview);
                UtilHelper.setSupportHeight(newVcodeActivity.getPageContext().getPageActivity(), this.f22327c, 1.2631578f);
                this.f22327c.setBackgroundColor(newVcodeActivity.getResources().getColor(17170443));
                this.f22327c.setInitialScale(100);
                this.f22327c.getSettings().setJavaScriptEnabled(true);
                this.f22327c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f22327c.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.3
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeView.this.i = true;
                        if (NewVcodeView.this.f22326b != null) {
                            NewVcodeView.this.f22326b.onPageFinished(webView, str);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeView.this.h(false);
                        NewVcodeView.this.f22325a.showToast(R.string.neterror);
                        NewVcodeView.this.f22325a.finish();
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (StringUtils.isNull(str)) {
                            return false;
                        }
                        if (!NewVcodeView.this.i) {
                            NewVcodeView.this.i = true;
                            e.a().postDelayed(NewVcodeView.this.j, 500L);
                            if (NewVcodeView.this.f22326b != null) {
                                NewVcodeView.this.f22326b.onPageFinished(webView, str);
                            }
                        }
                        if (NewVcodeView.this.f22326b == null) {
                            return false;
                        }
                        return NewVcodeView.this.f22326b.b(webView, str);
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
        return this.f22325a;
    }

    public WebView getWebView() {
        return this.f22327c;
    }

    public final void h(boolean z) {
        if (this.f22330f == null) {
            a aVar = new a(this.f22325a.getPageContext());
            this.f22330f = aVar;
            aVar.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.vcode.newVcode.NewVcodeView.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeView.this.f22325a.finish();
                }
            });
        }
        this.f22330f.h(z);
    }

    public void onDestory() {
        e.a().removeCallbacks(this.j);
    }

    public void runJsMethod(String str, String str2) {
        if (this.f22327c != null) {
            this.f22327c.loadUrl("javascript:window." + str + "(" + str2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void setPresenter(b bVar) {
        this.f22326b = bVar;
        this.i = false;
    }

    public void setRatio(float f2) {
        this.k = f2;
    }

    public void showPostThreadLoadingView(boolean z) {
        View view = this.f22329e;
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
            this.f22332h.c(str);
        } else {
            this.f22332h.b(str);
        }
    }

    public void showWebView(boolean z) {
        h(!z);
        BaseWebView baseWebView = this.f22327c;
        if (baseWebView != null) {
            if (z) {
                UtilHelper.setSupportHeight(this.f22325a.getPageContext().getPageActivity(), this.f22327c, this.k);
                this.f22327c.setVisibility(0);
                return;
            }
            baseWebView.setVisibility(8);
        }
    }

    public void showWebViewDelay(int i) {
        e.a().postDelayed(this.j, i);
    }
}
