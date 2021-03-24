package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f23256a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f23257b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23258c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f23259d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f23260e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f23261f;

    /* renamed from: g  reason: collision with root package name */
    public ey f23262g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f23261f = context;
        this.f23262g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            (i2 % 2 == 1 ? this.f23259d : this.f23260e).add(arrayList.get(i));
            i = i2;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f23261f);
        this.f23257b = linearLayout;
        linearLayout.setOrientation(1);
        this.f23257b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f23256a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23261f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23261f, 2.0f), com.baidu.ufosdk.f.i.a(this.f23261f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23261f, 14.0f));
        for (int i = 0; i < this.f23259d.size(); i++) {
            e eVar = new e(this.f23261f);
            eVar.a();
            eVar.a((String) this.f23259d.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f23257b.addView(eVar, this.f23256a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f23257b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f23261f);
        this.f23258c = linearLayout;
        linearLayout.setOrientation(1);
        this.f23258c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f23256a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23261f, 5.0f), com.baidu.ufosdk.f.i.a(this.f23261f, 2.0f), com.baidu.ufosdk.f.i.a(this.f23261f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23261f, 14.0f));
        for (int i = 0; i < this.f23260e.size(); i++) {
            e eVar = new e(this.f23261f);
            eVar.a();
            eVar.a((String) this.f23260e.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f23258c.addView(eVar, this.f23256a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f23258c;
    }
}
