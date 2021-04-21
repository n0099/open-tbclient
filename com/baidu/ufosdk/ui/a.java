package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public Context f22734c;

    /* renamed from: e  reason: collision with root package name */
    public d f22736e;

    /* renamed from: f  reason: collision with root package name */
    public int f22737f = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f22732a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f22733b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f22735d = new ArrayList();

    public a(ArrayList arrayList, Context context, d dVar) {
        this.f22734c = context;
        this.f22736e = dVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            (i2 % 2 == 1 ? this.f22732a : this.f22733b).add(arrayList.get(i));
            i = i2;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f22734c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22734c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22734c, 2.0f), com.baidu.ufosdk.f.i.a(this.f22734c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22734c, 14.0f));
        for (int i = 0; i < this.f22732a.size(); i++) {
            e eVar = new e(this.f22734c);
            eVar.a();
            eVar.a((String) this.f22732a.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new b(this, eVar));
        }
        return linearLayout;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f22734c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22734c, 5.0f), com.baidu.ufosdk.f.i.a(this.f22734c, 2.0f), com.baidu.ufosdk.f.i.a(this.f22734c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22734c, 14.0f));
        for (int i = 0; i < this.f22733b.size(); i++) {
            e eVar = new e(this.f22734c);
            eVar.a();
            eVar.a((String) this.f22733b.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new c(this, eVar));
        }
        return linearLayout;
    }

    public final ArrayList c() {
        return this.f22735d;
    }
}
