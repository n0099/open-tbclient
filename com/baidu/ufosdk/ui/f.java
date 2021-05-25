package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f22837a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f22838b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f22839c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f22840d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f22841e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f22842f;

    /* renamed from: g  reason: collision with root package name */
    public ey f22843g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f22842f = context;
        this.f22843g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            (i3 % 2 == 1 ? this.f22840d : this.f22841e).add(arrayList.get(i2));
            i2 = i3;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f22842f);
        this.f22838b = linearLayout;
        linearLayout.setOrientation(1);
        this.f22838b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22837a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22842f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22842f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22842f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22842f, 14.0f));
        for (int i2 = 0; i2 < this.f22840d.size(); i2++) {
            e eVar = new e(this.f22842f);
            eVar.a();
            eVar.a((String) this.f22840d.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22838b.addView(eVar, this.f22837a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f22838b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f22842f);
        this.f22839c = linearLayout;
        linearLayout.setOrientation(1);
        this.f22839c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22837a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22842f, 5.0f), com.baidu.ufosdk.f.i.a(this.f22842f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22842f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22842f, 14.0f));
        for (int i2 = 0; i2 < this.f22841e.size(); i2++) {
            e eVar = new e(this.f22842f);
            eVar.a();
            eVar.a((String) this.f22841e.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22839c.addView(eVar, this.f22837a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f22839c;
    }
}
