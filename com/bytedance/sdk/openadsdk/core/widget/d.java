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
import com.bytedance.sdk.openadsdk.utils.ad;
/* loaded from: classes6.dex */
public class d extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f28644a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28645b;

    /* renamed from: c  reason: collision with root package name */
    public Button f28646c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28647d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28648e;

    /* renamed from: f  reason: collision with root package name */
    public TTRoundRectImageView f28649f;

    /* renamed from: g  reason: collision with root package name */
    public Context f28650g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f28651h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f28652i;
    public String j;
    public String k;
    public String l;
    public String m;
    public a n;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);

        void d(Dialog dialog);
    }

    public d(Context context) {
        super(context, ad.g(context, "tt_dialog_full"));
        this.f28650g = context;
    }

    private void b() {
        if (this.f28650g == null) {
            this.f28650g = p.a();
        }
        TextView textView = this.f28644a;
        if (textView != null) {
            textView.setText(this.j);
        }
        if (this.f28649f != null && !TextUtils.isEmpty(this.l)) {
            com.bytedance.sdk.openadsdk.i.e.c().a(this.l, this.f28649f);
        }
        if (this.f28652i != null) {
            String a2 = ad.a(this.f28650g, "tt_open_app_detail_developer");
            this.f28652i.setText(TextUtils.isEmpty(this.m) ? String.format(a2, "补充中，可于应用官网查看") : String.format(a2, this.m));
        }
        if (this.f28645b != null) {
            String a3 = ad.a(this.f28650g, "tt_open_app_version");
            this.f28645b.setText(TextUtils.isEmpty(this.k) ? String.format(a3, "暂无") : String.format(a3, this.k));
        }
    }

    public d c(String str) {
        this.l = str;
        return this;
    }

    public d d(String str) {
        this.m = str;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28650g, "tt_common_download_dialog"));
        setCanceledOnTouchOutside(false);
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private void a() {
        this.f28644a = (TextView) findViewById(ad.e(this.f28650g, "tt_download_title"));
        this.f28647d = (TextView) findViewById(ad.e(this.f28650g, "tt_download_app_detail"));
        this.f28646c = (Button) findViewById(ad.e(this.f28650g, "tt_download_btn"));
        this.f28645b = (TextView) findViewById(ad.e(this.f28650g, "tt_download_app_version"));
        this.f28648e = (TextView) findViewById(ad.e(this.f28650g, "tt_download_cancel"));
        this.f28651h = (TextView) findViewById(ad.e(this.f28650g, "tt_download_app_privacy"));
        this.f28652i = (TextView) findViewById(ad.e(this.f28650g, "tt_download_app_developer"));
        this.f28649f = (TTRoundRectImageView) findViewById(ad.e(this.f28650g, "tt_download_icon"));
        this.f28646c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.a(d.this);
                }
            }
        });
        this.f28647d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.b(d.this);
                }
            }
        });
        this.f28648e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.c(d.this);
                }
            }
        });
        this.f28651h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.d(d.this);
                }
            }
        });
    }

    public d a(@NonNull String str) {
        this.j = str;
        return this;
    }

    public d a(a aVar) {
        this.n = aVar;
        return this;
    }

    public d b(@NonNull String str) {
        this.k = str;
        return this;
    }
}
