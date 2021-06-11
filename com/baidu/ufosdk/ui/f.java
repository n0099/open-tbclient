package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f22940a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f22941b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f22942c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f22943d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f22944e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f22945f;

    /* renamed from: g  reason: collision with root package name */
    public ey f22946g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f22945f = context;
        this.f22946g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            (i3 % 2 == 1 ? this.f22943d : this.f22944e).add(arrayList.get(i2));
            i2 = i3;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f22945f);
        this.f22941b = linearLayout;
        linearLayout.setOrientation(1);
        this.f22941b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22940a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22945f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22945f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22945f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22945f, 14.0f));
        for (int i2 = 0; i2 < this.f22943d.size(); i2++) {
            e eVar = new e(this.f22945f);
            eVar.a();
            eVar.a((String) this.f22943d.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22941b.addView(eVar, this.f22940a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f22941b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f22945f);
        this.f22942c = linearLayout;
        linearLayout.setOrientation(1);
        this.f22942c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22940a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22945f, 5.0f), com.baidu.ufosdk.f.i.a(this.f22945f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22945f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22945f, 14.0f));
        for (int i2 = 0; i2 < this.f22944e.size(); i2++) {
            e eVar = new e(this.f22945f);
            eVar.a();
            eVar.a((String) this.f22944e.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22942c.addView(eVar, this.f22940a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f22942c;
    }
}
