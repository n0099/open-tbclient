package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public Context f22803c;

    /* renamed from: e  reason: collision with root package name */
    public d f22805e;

    /* renamed from: f  reason: collision with root package name */
    public int f22806f = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f22801a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f22802b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f22804d = new ArrayList();

    public a(ArrayList arrayList, Context context, d dVar) {
        this.f22803c = context;
        this.f22805e = dVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            (i3 % 2 == 1 ? this.f22801a : this.f22802b).add(arrayList.get(i2));
            i2 = i3;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f22803c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22803c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22803c, 2.0f), com.baidu.ufosdk.f.i.a(this.f22803c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22803c, 14.0f));
        for (int i2 = 0; i2 < this.f22801a.size(); i2++) {
            e eVar = new e(this.f22803c);
            eVar.a();
            eVar.a((String) this.f22801a.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new b(this, eVar));
        }
        return linearLayout;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f22803c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22803c, 5.0f), com.baidu.ufosdk.f.i.a(this.f22803c, 2.0f), com.baidu.ufosdk.f.i.a(this.f22803c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22803c, 14.0f));
        for (int i2 = 0; i2 < this.f22802b.size(); i2++) {
            e eVar = new e(this.f22803c);
            eVar.a();
            eVar.a((String) this.f22802b.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new c(this, eVar));
        }
        return linearLayout;
    }

    public final ArrayList c() {
        return this.f22804d;
    }
}
