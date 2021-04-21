package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ad;
/* loaded from: classes5.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public a f28582a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28583b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28584c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28585d;

    /* renamed from: e  reason: collision with root package name */
    public Button f28586e;

    /* renamed from: f  reason: collision with root package name */
    public Button f28587f;

    /* renamed from: g  reason: collision with root package name */
    public View f28588g;

    /* renamed from: h  reason: collision with root package name */
    public Context f28589h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public boolean n;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public c(Context context) {
        super(context, ad.g(context, "tt_custom_dialog"));
        this.m = -1;
        this.n = false;
        this.f28589h = context;
    }

    private void a() {
        this.f28587f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = c.this.f28582a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        this.f28586e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = c.this.f28582a;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
    }

    private void b() {
        if (!TextUtils.isEmpty(this.j)) {
            this.f28584c.setText(this.j);
            this.f28584c.setVisibility(0);
        } else {
            this.f28584c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.f28585d.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f28587f.setText(this.k);
        } else {
            this.f28587f.setText("确定");
        }
        if (!TextUtils.isEmpty(this.l)) {
            this.f28586e.setText(this.l);
        } else {
            this.f28586e.setText("取消");
        }
        int i = this.m;
        if (i != -1) {
            this.f28583b.setImageResource(i);
            this.f28583b.setVisibility(0);
        } else {
            this.f28583b.setVisibility(8);
        }
        if (this.n) {
            this.f28588g.setVisibility(8);
            this.f28586e.setVisibility(8);
            return;
        }
        this.f28586e.setVisibility(0);
        this.f28588g.setVisibility(0);
    }

    private void c() {
        this.f28586e = (Button) findViewById(ad.e(this.f28589h, "tt_negtive"));
        this.f28587f = (Button) findViewById(ad.e(this.f28589h, "tt_positive"));
        this.f28584c = (TextView) findViewById(ad.e(this.f28589h, "tt_title"));
        this.f28585d = (TextView) findViewById(ad.e(this.f28589h, "tt_message"));
        this.f28583b = (ImageView) findViewById(ad.e(this.f28589h, "tt_image"));
        this.f28588g = findViewById(ad.e(this.f28589h, "tt_column_line"));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28589h, "tt_custom_dailog_layout"));
        setCanceledOnTouchOutside(false);
        c();
        b();
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    public c a(a aVar) {
        this.f28582a = aVar;
        return this;
    }

    public c a(String str) {
        this.i = str;
        return this;
    }

    public c c(String str) {
        this.l = str;
        return this;
    }

    public c b(String str) {
        this.k = str;
        return this;
    }
}
