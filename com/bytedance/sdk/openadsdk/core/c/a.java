package com.bytedance.sdk.openadsdk.core.c;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
class a extends BackupView {
    private static i[] h = {new i(1, 1.0f, 300, 300), new i(2, 0.6666667f, 300, 450), new i(3, 1.5f, 300, 200)};
    private View i;
    private NativeExpressView j;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a k;
    private int l;
    private Dialog m;

    public a(@NonNull Context context) {
        super(context);
        this.l = 1;
        this.f6617a = context;
    }

    public void a(Dialog dialog) {
        this.m = dialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        setBackgroundColor(-1);
        this.f6618b = lVar;
        this.j = nativeExpressView;
        this.k = aVar;
        this.e = "interaction";
        this.j.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void b() {
        i a2 = a(this.j.getExpectExpressWidth(), this.j.getExpectExpressHeight());
        if (this.j.getExpectExpressWidth() > 0 && this.j.getExpectExpressHeight() > 0) {
            if (this.j.getExpectExpressWidth() > this.j.getExpectExpressHeight()) {
                this.f = ak.c(this.f6617a, this.j.getExpectExpressHeight() * a2.f6647b);
                this.g = ak.c(this.f6617a, this.j.getExpectExpressHeight());
            } else {
                this.f = ak.c(this.f6617a, this.j.getExpectExpressWidth());
                this.g = ak.c(this.f6617a, this.j.getExpectExpressWidth() / a2.f6647b);
            }
        } else {
            this.f = ak.c(this.f6617a, a2.c);
            this.g = ak.c(this.f6617a, a2.d);
        }
        if (this.f > 0 && this.f > ak.c(this.f6617a)) {
            float c = ak.c(this.f6617a) / this.f;
            this.f = ak.c(this.f6617a);
            this.g = Float.valueOf(c * this.g).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f, this.g);
        }
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        setLayoutParams(layoutParams);
        if (a2.f6646a == 1) {
            c();
        } else if (a2.f6646a == 2) {
            d();
        } else if (a2.f6646a == 3) {
            e();
        } else {
            c();
        }
    }

    private void a(ImageView imageView) {
        e.a(this.f6617a).a(this.f6618b.M().get(0).a(), imageView);
    }

    private void c() {
        this.i = LayoutInflater.from(this.f6617a).inflate(ac.f(this.f6617a, "tt_backup_insert_layout1"), (ViewGroup) this, true);
        ImageView imageView = (ImageView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_img"));
        View findViewById = this.i.findViewById(ac.e(this.f6617a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_icon"));
        TextView textView = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_title"));
        TextView textView2 = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_download"));
        TextView textView4 = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_dislike"));
        int a2 = (int) ak.a(this.f6617a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        a(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.f6618b.S())) {
            textView3.setText(this.f6618b.S());
        }
        a(imageView);
        e.a(this.f6617a).a(this.f6618b.I().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, false);
        a((View) textView3, true);
        a((View) textView4, true);
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.m != null) {
                        a.this.m.dismiss();
                    }
                }
            });
        }
    }

    private void d() {
        this.i = LayoutInflater.from(this.f6617a).inflate(ac.f(this.f6617a, "tt_backup_insert_layout2"), (ViewGroup) this, true);
        ImageView imageView = (ImageView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_img"));
        View findViewById = this.i.findViewById(ac.e(this.f6617a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_icon"));
        TextView textView = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_title"));
        TextView textView2 = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_download"));
        TextView textView4 = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_dislike"));
        int a2 = (int) ak.a(this.f6617a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        a(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.f6618b.S())) {
            textView3.setText(this.f6618b.S());
        }
        a(imageView);
        e.a(this.f6617a).a(this.f6618b.I().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, false);
        a((View) textView3, true);
        a((View) textView4, true);
    }

    private void e() {
        this.i = LayoutInflater.from(this.f6617a).inflate(ac.f(this.f6617a, "tt_backup_insert_layout3"), (ViewGroup) this, true);
        View findViewById = this.i.findViewById(ac.e(this.f6617a, "tt_bu_close"));
        TextView textView = (TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_dislike"));
        int a2 = (int) ak.a(this.f6617a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        a(findViewById);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        a((ImageView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_img")));
        ((TextView) this.i.findViewById(ac.e(this.f6617a, "tt_bu_desc"))).setText(getDescription());
        a((View) this, false);
        a(this.i, true);
        a((View) textView, true);
    }

    private i a(int i, int i2) {
        try {
            float floatValue = Float.valueOf(i).floatValue() / Float.valueOf(i2).floatValue();
            i iVar = h[0];
            float f = Float.MAX_VALUE;
            i[] iVarArr = h;
            int length = iVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                i iVar2 = iVarArr[i3];
                float abs = Math.abs(iVar2.f6647b - floatValue);
                if (abs > f) {
                    abs = f;
                    iVar2 = iVar;
                }
                i3++;
                f = abs;
                iVar = iVar2;
            }
            return iVar;
        } catch (Throwable th) {
            return h[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, j jVar) {
        if (this.j != null) {
            this.j.a(i, jVar);
        }
    }
}
