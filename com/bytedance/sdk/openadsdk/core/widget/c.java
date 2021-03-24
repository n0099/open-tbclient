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
/* loaded from: classes6.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public a f28888a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28889b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28890c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28891d;

    /* renamed from: e  reason: collision with root package name */
    public Button f28892e;

    /* renamed from: f  reason: collision with root package name */
    public Button f28893f;

    /* renamed from: g  reason: collision with root package name */
    public View f28894g;

    /* renamed from: h  reason: collision with root package name */
    public Context f28895h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public boolean n;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public c(Context context) {
        super(context, ad.g(context, "tt_custom_dialog"));
        this.m = -1;
        this.n = false;
        this.f28895h = context;
    }

    private void a() {
        this.f28893f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = c.this.f28888a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        this.f28892e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = c.this.f28888a;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
    }

    private void b() {
        if (!TextUtils.isEmpty(this.j)) {
            this.f28890c.setText(this.j);
            this.f28890c.setVisibility(0);
        } else {
            this.f28890c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.f28891d.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f28893f.setText(this.k);
        } else {
            this.f28893f.setText("确定");
        }
        if (!TextUtils.isEmpty(this.l)) {
            this.f28892e.setText(this.l);
        } else {
            this.f28892e.setText("取消");
        }
        int i = this.m;
        if (i != -1) {
            this.f28889b.setImageResource(i);
            this.f28889b.setVisibility(0);
        } else {
            this.f28889b.setVisibility(8);
        }
        if (this.n) {
            this.f28894g.setVisibility(8);
            this.f28892e.setVisibility(8);
            return;
        }
        this.f28892e.setVisibility(0);
        this.f28894g.setVisibility(0);
    }

    private void c() {
        this.f28892e = (Button) findViewById(ad.e(this.f28895h, "tt_negtive"));
        this.f28893f = (Button) findViewById(ad.e(this.f28895h, "tt_positive"));
        this.f28890c = (TextView) findViewById(ad.e(this.f28895h, "tt_title"));
        this.f28891d = (TextView) findViewById(ad.e(this.f28895h, "tt_message"));
        this.f28889b = (ImageView) findViewById(ad.e(this.f28895h, "tt_image"));
        this.f28894g = findViewById(ad.e(this.f28895h, "tt_column_line"));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28895h, "tt_custom_dailog_layout"));
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
        this.f28888a = aVar;
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
