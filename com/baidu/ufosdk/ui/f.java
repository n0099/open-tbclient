package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f22950a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f22951b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f22952c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f22953d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f22954e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f22955f;

    /* renamed from: g  reason: collision with root package name */
    public ey f22956g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f22955f = context;
        this.f22956g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            (i2 % 2 == 1 ? this.f22953d : this.f22954e).add(arrayList.get(i));
            i = i2;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f22955f);
        this.f22951b = linearLayout;
        linearLayout.setOrientation(1);
        this.f22951b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22950a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22955f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22955f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22955f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22955f, 14.0f));
        for (int i = 0; i < this.f22953d.size(); i++) {
            e eVar = new e(this.f22955f);
            eVar.a();
            eVar.a((String) this.f22953d.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22951b.addView(eVar, this.f22950a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f22951b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f22955f);
        this.f22952c = linearLayout;
        linearLayout.setOrientation(1);
        this.f22952c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22950a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22955f, 5.0f), com.baidu.ufosdk.f.i.a(this.f22955f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22955f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22955f, 14.0f));
        for (int i = 0; i < this.f22954e.size(); i++) {
            e eVar = new e(this.f22955f);
            eVar.a();
            eVar.a((String) this.f22954e.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22952c.addView(eVar, this.f22950a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f22952c;
    }
}
