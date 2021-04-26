package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public Context f23444c;

    /* renamed from: e  reason: collision with root package name */
    public d f23446e;

    /* renamed from: f  reason: collision with root package name */
    public int f23447f = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f23442a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f23443b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f23445d = new ArrayList();

    public a(ArrayList arrayList, Context context, d dVar) {
        this.f23444c = context;
        this.f23446e = dVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            (i3 % 2 == 1 ? this.f23442a : this.f23443b).add(arrayList.get(i2));
            i2 = i3;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f23444c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23444c, 15.0f), com.baidu.ufosdk.f.i.a(this.f23444c, 2.0f), com.baidu.ufosdk.f.i.a(this.f23444c, 15.0f), com.baidu.ufosdk.f.i.a(this.f23444c, 14.0f));
        for (int i2 = 0; i2 < this.f23442a.size(); i2++) {
            e eVar = new e(this.f23444c);
            eVar.a();
            eVar.a((String) this.f23442a.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new b(this, eVar));
        }
        return linearLayout;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f23444c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23444c, 5.0f), com.baidu.ufosdk.f.i.a(this.f23444c, 2.0f), com.baidu.ufosdk.f.i.a(this.f23444c, 15.0f), com.baidu.ufosdk.f.i.a(this.f23444c, 14.0f));
        for (int i2 = 0; i2 < this.f23443b.size(); i2++) {
            e eVar = new e(this.f23444c);
            eVar.a();
            eVar.a((String) this.f23443b.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new c(this, eVar));
        }
        return linearLayout;
    }

    public final ArrayList c() {
        return this.f23445d;
    }
}
