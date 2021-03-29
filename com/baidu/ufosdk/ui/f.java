package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f23257a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f23258b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f23259c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f23260d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f23261e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f23262f;

    /* renamed from: g  reason: collision with root package name */
    public ey f23263g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f23262f = context;
        this.f23263g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            (i2 % 2 == 1 ? this.f23260d : this.f23261e).add(arrayList.get(i));
            i = i2;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f23262f);
        this.f23258b = linearLayout;
        linearLayout.setOrientation(1);
        this.f23258b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f23257a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23262f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23262f, 2.0f), com.baidu.ufosdk.f.i.a(this.f23262f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23262f, 14.0f));
        for (int i = 0; i < this.f23260d.size(); i++) {
            e eVar = new e(this.f23262f);
            eVar.a();
            eVar.a((String) this.f23260d.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f23258b.addView(eVar, this.f23257a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f23258b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f23262f);
        this.f23259c = linearLayout;
        linearLayout.setOrientation(1);
        this.f23259c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f23257a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23262f, 5.0f), com.baidu.ufosdk.f.i.a(this.f23262f, 2.0f), com.baidu.ufosdk.f.i.a(this.f23262f, 15.0f), com.baidu.ufosdk.f.i.a(this.f23262f, 14.0f));
        for (int i = 0; i < this.f23261e.size(); i++) {
            e eVar = new e(this.f23262f);
            eVar.a();
            eVar.a((String) this.f23261e.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f23259c.addView(eVar, this.f23257a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f23259c;
    }
}
