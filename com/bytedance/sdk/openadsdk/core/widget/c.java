package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.pay.PayHelper;
import com.bytedance.sdk.openadsdk.utils.ac;
/* loaded from: classes4.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public a f7094a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f7095b;
    private TextView c;
    private TextView d;
    private Button e;
    private Button f;
    private View g;
    private Context h;
    private String i;
    private String j;
    private String k;
    private String l;
    private int m;
    private boolean n;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    public c(Context context) {
        super(context, ac.g(context, "tt_custom_dialog"));
        this.m = -1;
        this.n = false;
        this.h = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.h, "tt_custom_dailog_layout"));
        setCanceledOnTouchOutside(false);
        c();
        b();
        a();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    private void a() {
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f7094a != null) {
                    c.this.f7094a.a();
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f7094a != null) {
                    c.this.f7094a.b();
                }
            }
        });
    }

    private void b() {
        if (!TextUtils.isEmpty(this.j)) {
            this.c.setText(this.j);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.d.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.f.setText(this.k);
        } else {
            this.f.setText("确定");
        }
        if (!TextUtils.isEmpty(this.l)) {
            this.e.setText(this.l);
        } else {
            this.e.setText(PayHelper.STATUS_CANCEL_DESC);
        }
        if (this.m != -1) {
            this.f7095b.setImageResource(this.m);
            this.f7095b.setVisibility(0);
        } else {
            this.f7095b.setVisibility(8);
        }
        if (this.n) {
            this.g.setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.g.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private void c() {
        this.e = (Button) findViewById(ac.e(this.h, "tt_negtive"));
        this.f = (Button) findViewById(ac.e(this.h, "tt_positive"));
        this.c = (TextView) findViewById(ac.e(this.h, "tt_title"));
        this.d = (TextView) findViewById(ac.e(this.h, "tt_message"));
        this.f7095b = (ImageView) findViewById(ac.e(this.h, "tt_image"));
        this.g = findViewById(ac.e(this.h, "tt_column_line"));
    }

    public c a(a aVar) {
        this.f7094a = aVar;
        return this;
    }

    public c a(String str) {
        this.i = str;
        return this;
    }

    public c b(String str) {
        this.k = str;
        return this;
    }

    public c c(String str) {
        this.l = str;
        return this;
    }
}
