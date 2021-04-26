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
    public a f29459a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f29460b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f29461c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f29462d;

    /* renamed from: e  reason: collision with root package name */
    public Button f29463e;

    /* renamed from: f  reason: collision with root package name */
    public Button f29464f;

    /* renamed from: g  reason: collision with root package name */
    public View f29465g;

    /* renamed from: h  reason: collision with root package name */
    public Context f29466h;

    /* renamed from: i  reason: collision with root package name */
    public String f29467i;
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
        this.f29466h = context;
    }

    private void a() {
        this.f29464f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = c.this.f29459a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        this.f29463e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = c.this.f29459a;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
    }

    private void b() {
        if (!TextUtils.isEmpty(this.j)) {
            this.f29461c.setText(this.j);
            this.f29461c.setVisibility(0);
        } else {
            this.f29461c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f29467i)) {
            this.f29462d.setText(this.f29467i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f29464f.setText(this.k);
        } else {
            this.f29464f.setText("确定");
        }
        if (!TextUtils.isEmpty(this.l)) {
            this.f29463e.setText(this.l);
        } else {
            this.f29463e.setText("取消");
        }
        int i2 = this.m;
        if (i2 != -1) {
            this.f29460b.setImageResource(i2);
            this.f29460b.setVisibility(0);
        } else {
            this.f29460b.setVisibility(8);
        }
        if (this.n) {
            this.f29465g.setVisibility(8);
            this.f29463e.setVisibility(8);
            return;
        }
        this.f29463e.setVisibility(0);
        this.f29465g.setVisibility(0);
    }

    private void c() {
        this.f29463e = (Button) findViewById(ad.e(this.f29466h, "tt_negtive"));
        this.f29464f = (Button) findViewById(ad.e(this.f29466h, "tt_positive"));
        this.f29461c = (TextView) findViewById(ad.e(this.f29466h, "tt_title"));
        this.f29462d = (TextView) findViewById(ad.e(this.f29466h, "tt_message"));
        this.f29460b = (ImageView) findViewById(ad.e(this.f29466h, "tt_image"));
        this.f29465g = findViewById(ad.e(this.f29466h, "tt_column_line"));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f29466h, "tt_custom_dailog_layout"));
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
        this.f29459a = aVar;
        return this;
    }

    public c a(String str) {
        this.f29467i = str;
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
