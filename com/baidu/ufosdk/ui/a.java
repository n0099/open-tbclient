package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public Context f22689c;

    /* renamed from: e  reason: collision with root package name */
    public d f22691e;

    /* renamed from: f  reason: collision with root package name */
    public int f22692f = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f22687a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f22688b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f22690d = new ArrayList();

    public a(ArrayList arrayList, Context context, d dVar) {
        this.f22689c = context;
        this.f22691e = dVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            (i3 % 2 == 1 ? this.f22687a : this.f22688b).add(arrayList.get(i2));
            i2 = i3;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f22689c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22689c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22689c, 2.0f), com.baidu.ufosdk.f.i.a(this.f22689c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22689c, 14.0f));
        for (int i2 = 0; i2 < this.f22687a.size(); i2++) {
            e eVar = new e(this.f22689c);
            eVar.a();
            eVar.a((String) this.f22687a.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new b(this, eVar));
        }
        return linearLayout;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f22689c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22689c, 5.0f), com.baidu.ufosdk.f.i.a(this.f22689c, 2.0f), com.baidu.ufosdk.f.i.a(this.f22689c, 15.0f), com.baidu.ufosdk.f.i.a(this.f22689c, 14.0f));
        for (int i2 = 0; i2 < this.f22688b.size(); i2++) {
            e eVar = new e(this.f22689c);
            eVar.a();
            eVar.a((String) this.f22688b.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new c(this, eVar));
        }
        return linearLayout;
    }

    public final ArrayList c() {
        return this.f22690d;
    }
}
