package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ac;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    private SSWebView f4604a;
    private Context b;
    private TextView c;
    private String d;
    private a e;
    private String f;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Dialog dialog);
    }

    public b(Context context, String str) {
        super(context, ac.g(context, "DialogFullscreen"));
        this.b = context;
        this.f = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.b, "tt_app_privacy_dialog"));
        b();
        a();
    }

    protected void a() {
        this.f4604a = (SSWebView) findViewById(ac.e(this.b, "tt_privacy_webview"));
        this.c = (TextView) findViewById(ac.e(this.b, "tt_app_privacy_back_tv"));
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.e != null) {
                    b.this.e.a(b.this);
                }
            }
        });
        this.f4604a.getSettings().setJavaScriptEnabled(true);
        this.f4604a.getSettings().setDisplayZoomControls(false);
        this.f4604a.getSettings().setCacheMode(2);
        this.f4604a.loadUrl(this.d);
    }

    private void b() {
        if (TextUtils.isEmpty(this.f)) {
            this.d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.c b = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(this.f));
            if (b != null) {
                this.d = b.d();
                if (TextUtils.isEmpty(this.d)) {
                    this.d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.e != null) {
            this.e.a(this);
        }
    }

    public b a(a aVar) {
        this.e = aVar;
        return this;
    }
}
