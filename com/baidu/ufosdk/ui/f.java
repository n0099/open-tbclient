package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f22908a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f22909b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f22910c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f22911d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f22912e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f22913f;

    /* renamed from: g  reason: collision with root package name */
    public ey f22914g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f22913f = context;
        this.f22914g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            (i3 % 2 == 1 ? this.f22911d : this.f22912e).add(arrayList.get(i2));
            i2 = i3;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f22913f);
        this.f22909b = linearLayout;
        linearLayout.setOrientation(1);
        this.f22909b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22908a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22913f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22913f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22913f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22913f, 14.0f));
        for (int i2 = 0; i2 < this.f22911d.size(); i2++) {
            e eVar = new e(this.f22913f);
            eVar.a();
            eVar.a((String) this.f22911d.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22909b.addView(eVar, this.f22908a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f22909b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f22913f);
        this.f22910c = linearLayout;
        linearLayout.setOrientation(1);
        this.f22910c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22908a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22913f, 5.0f), com.baidu.ufosdk.f.i.a(this.f22913f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22913f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22913f, 14.0f));
        for (int i2 = 0; i2 < this.f22912e.size(); i2++) {
            e eVar = new e(this.f22913f);
            eVar.a();
            eVar.a((String) this.f22912e.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22910c.addView(eVar, this.f22908a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f22910c;
    }
}
