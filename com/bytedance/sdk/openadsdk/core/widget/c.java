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
    public a f28574a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28575b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28576c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28577d;

    /* renamed from: e  reason: collision with root package name */
    public Button f28578e;

    /* renamed from: f  reason: collision with root package name */
    public Button f28579f;

    /* renamed from: g  reason: collision with root package name */
    public View f28580g;

    /* renamed from: h  reason: collision with root package name */
    public Context f28581h;
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
        this.f28581h = context;
    }

    private void a() {
        this.f28579f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = c.this.f28574a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        this.f28578e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = c.this.f28574a;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
    }

    private void b() {
        if (!TextUtils.isEmpty(this.j)) {
            this.f28576c.setText(this.j);
            this.f28576c.setVisibility(0);
        } else {
            this.f28576c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.f28577d.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f28579f.setText(this.k);
        } else {
            this.f28579f.setText("确定");
        }
        if (!TextUtils.isEmpty(this.l)) {
            this.f28578e.setText(this.l);
        } else {
            this.f28578e.setText("取消");
        }
        int i = this.m;
        if (i != -1) {
            this.f28575b.setImageResource(i);
            this.f28575b.setVisibility(0);
        } else {
            this.f28575b.setVisibility(8);
        }
        if (this.n) {
            this.f28580g.setVisibility(8);
            this.f28578e.setVisibility(8);
            return;
        }
        this.f28578e.setVisibility(0);
        this.f28580g.setVisibility(0);
    }

    private void c() {
        this.f28578e = (Button) findViewById(ad.e(this.f28581h, "tt_negtive"));
        this.f28579f = (Button) findViewById(ad.e(this.f28581h, "tt_positive"));
        this.f28576c = (TextView) findViewById(ad.e(this.f28581h, "tt_title"));
        this.f28577d = (TextView) findViewById(ad.e(this.f28581h, "tt_message"));
        this.f28575b = (ImageView) findViewById(ad.e(this.f28581h, "tt_image"));
        this.f28580g = findViewById(ad.e(this.f28581h, "tt_column_line"));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28581h, "tt_custom_dailog_layout"));
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
        this.f28574a = aVar;
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
