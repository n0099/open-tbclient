package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f23663a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f23664b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23665c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f23666d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f23667e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f23668f;

    /* renamed from: g  reason: collision with root package name */
    public ey f23669g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f23668f = context;
        this.f23669g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            (i3 % 2 == 1 ? this.f23666d : this.f23667e).add(arrayList.get(i2));
            i2 = i3;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f23668f);
        this.f23664b = linearLayout;
        linearLayout.setOrientation(1);
        this.f23664b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f23663a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23668f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23668f, 2.0f), com.baidu.ufosdk.f.i.a(this.f23668f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23668f, 14.0f));
        for (int i2 = 0; i2 < this.f23666d.size(); i2++) {
            e eVar = new e(this.f23668f);
            eVar.a();
            eVar.a((String) this.f23666d.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f23664b.addView(eVar, this.f23663a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f23664b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f23668f);
        this.f23665c = linearLayout;
        linearLayout.setOrientation(1);
        this.f23665c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f23663a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23668f, 5.0f), com.baidu.ufosdk.f.i.a(this.f23668f, 2.0f), com.baidu.ufosdk.f.i.a(this.f23668f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23668f, 14.0f));
        for (int i2 = 0; i2 < this.f23667e.size(); i2++) {
            e eVar = new e(this.f23668f);
            eVar.a();
            eVar.a((String) this.f23667e.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f23665c.addView(eVar, this.f23663a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f23665c;
    }
}
