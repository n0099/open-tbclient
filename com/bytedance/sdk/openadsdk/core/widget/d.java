package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ac;
/* loaded from: classes4.dex */
public class d extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f6798a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f6799b;
    private Button c;
    private TextView d;
    private TextView e;
    private TTRoundRectImageView f;
    private Context g;
    private TextView h;
    private TextView i;
    private String j;
    private String k;
    private String l;
    private String m;
    private a n;

    /* loaded from: classes4.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);

        void d(Dialog dialog);
    }

    public d(Context context) {
        super(context, ac.g(context, "DialogFullscreen"));
        this.g = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.g, "tt_common_download_dialog"));
        setCanceledOnTouchOutside(true);
        a();
    }

    private void a() {
        this.f6798a = (TextView) findViewById(ac.e(this.g, "tt_download_title"));
        this.d = (TextView) findViewById(ac.e(this.g, "tt_download_app_detail"));
        this.c = (Button) findViewById(ac.e(this.g, "tt_download_btn"));
        this.f6799b = (TextView) findViewById(ac.e(this.g, "tt_download_app_version"));
        this.e = (TextView) findViewById(ac.e(this.g, "tt_download_cancel"));
        this.h = (TextView) findViewById(ac.e(this.g, "tt_download_app_privacy"));
        this.i = (TextView) findViewById(ac.e(this.g, "tt_download_app_developer"));
        this.f = (TTRoundRectImageView) findViewById(ac.e(this.g, "tt_download_icon"));
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.a(d.this);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.b(d.this);
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.c(d.this);
                }
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.d(d.this);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.n != null) {
            this.n.c(this);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private void b() {
        if (this.g == null) {
            this.g = p.a();
        }
        if (this.f6798a != null) {
            this.f6798a.setText(this.j);
        }
        if (this.f != null && !TextUtils.isEmpty(this.l)) {
            com.bytedance.sdk.openadsdk.i.e.a(this.g).a(this.l, this.f);
        }
        if (this.i != null) {
            String a2 = ac.a(this.g, "tt_open_app_detail_developer");
            this.i.setText(TextUtils.isEmpty(this.m) ? String.format(a2, "补充中，可于应用官网查看") : String.format(a2, this.m));
        }
        if (this.f6799b != null) {
            String a3 = ac.a(this.g, "tt_open_app_version");
            this.f6799b.setText(TextUtils.isEmpty(this.k) ? String.format(a3, "暂无") : String.format(a3, this.k));
        }
    }

    public d a(@NonNull String str) {
        this.j = str;
        return this;
    }

    public d b(@NonNull String str) {
        this.k = str;
        return this;
    }

    public d c(String str) {
        this.l = str;
        return this;
    }

    public d d(String str) {
        this.m = str;
        return this;
    }

    public d a(a aVar) {
        this.n = aVar;
        return this;
    }
}
