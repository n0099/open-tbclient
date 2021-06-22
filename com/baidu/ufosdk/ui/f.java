package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f23022a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f23023b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23024c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f23025d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f23026e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f23027f;

    /* renamed from: g  reason: collision with root package name */
    public ey f23028g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f23027f = context;
        this.f23028g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            (i3 % 2 == 1 ? this.f23025d : this.f23026e).add(arrayList.get(i2));
            i2 = i3;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f23027f);
        this.f23023b = linearLayout;
        linearLayout.setOrientation(1);
        this.f23023b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f23022a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23027f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23027f, 2.0f), com.baidu.ufosdk.f.i.a(this.f23027f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23027f, 14.0f));
        for (int i2 = 0; i2 < this.f23025d.size(); i2++) {
            e eVar = new e(this.f23027f);
            eVar.a();
            eVar.a((String) this.f23025d.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f23023b.addView(eVar, this.f23022a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f23023b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f23027f);
        this.f23024c = linearLayout;
        linearLayout.setOrientation(1);
        this.f23024c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f23022a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23027f, 5.0f), com.baidu.ufosdk.f.i.a(this.f23027f, 2.0f), com.baidu.ufosdk.f.i.a(this.f23027f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23027f, 14.0f));
        for (int i2 = 0; i2 < this.f23026e.size(); i2++) {
            e eVar = new e(this.f23027f);
            eVar.a();
            eVar.a((String) this.f23026e.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f23024c.addView(eVar, this.f23022a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f23024c;
    }
}
