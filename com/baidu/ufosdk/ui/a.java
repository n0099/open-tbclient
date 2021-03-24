package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public Context f23040c;

    /* renamed from: e  reason: collision with root package name */
    public d f23042e;

    /* renamed from: f  reason: collision with root package name */
    public int f23043f = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f23038a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f23039b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f23041d = new ArrayList();

    public a(ArrayList arrayList, Context context, d dVar) {
        this.f23040c = context;
        this.f23042e = dVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            (i2 % 2 == 1 ? this.f23038a : this.f23039b).add(arrayList.get(i));
            i = i2;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f23040c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23040c, 15.0f), com.baidu.ufosdk.f.i.a(this.f23040c, 2.0f), com.baidu.ufosdk.f.i.a(this.f23040c, 15.0f), com.baidu.ufosdk.f.i.a(this.f23040c, 14.0f));
        for (int i = 0; i < this.f23038a.size(); i++) {
            e eVar = new e(this.f23040c);
            eVar.a();
            eVar.a((String) this.f23038a.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new b(this, eVar));
        }
        return linearLayout;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f23040c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23040c, 5.0f), com.baidu.ufosdk.f.i.a(this.f23040c, 2.0f), com.baidu.ufosdk.f.i.a(this.f23040c, 15.0f), com.baidu.ufosdk.f.i.a(this.f23040c, 14.0f));
        for (int i = 0; i < this.f23039b.size(); i++) {
            e eVar = new e(this.f23040c);
            eVar.a();
            eVar.a((String) this.f23039b.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new c(this, eVar));
        }
        return linearLayout;
    }

    public final ArrayList c() {
        return this.f23041d;
    }
}
