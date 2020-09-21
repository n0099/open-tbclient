package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public final class f {
    LinearLayout.LayoutParams a;
    LinearLayout b;
    LinearLayout c;
    private ArrayList d = new ArrayList();
    private ArrayList e = new ArrayList();
    private Context f;
    private ey g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f = context;
        this.g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if ((i + 1) % 2 == 1) {
                this.d.add(arrayList.get(i));
            } else {
                this.e.add(arrayList.get(i));
            }
        }
    }

    public final LinearLayout a() {
        this.b = new LinearLayout(this.f);
        this.b.setOrientation(1);
        this.b.setBackgroundColor(-1);
        this.a = new LinearLayout.LayoutParams(-1, -1);
        this.a.setMargins(com.baidu.ufosdk.f.i.a(this.f, 15.0f), com.baidu.ufosdk.f.i.a(this.f, 2.0f), com.baidu.ufosdk.f.i.a(this.f, 15.0f), com.baidu.ufosdk.f.i.a(this.f, 14.0f));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return this.b;
            }
            e eVar = new e(this.f);
            eVar.a();
            eVar.a((String) this.d.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.b.addView(eVar, this.a);
            eVar.setOnClickListener(new g(this, eVar));
            i = i2 + 1;
        }
    }

    public final LinearLayout b() {
        this.c = new LinearLayout(this.f);
        this.c.setOrientation(1);
        this.c.setBackgroundColor(-1);
        this.a = new LinearLayout.LayoutParams(-1, -1);
        this.a.setMargins(com.baidu.ufosdk.f.i.a(this.f, 5.0f), com.baidu.ufosdk.f.i.a(this.f, 2.0f), com.baidu.ufosdk.f.i.a(this.f, 15.0f), com.baidu.ufosdk.f.i.a(this.f, 14.0f));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return this.c;
            }
            e eVar = new e(this.f);
            eVar.a();
            eVar.a((String) this.e.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            this.c.addView(eVar, this.a);
            eVar.setOnClickListener(new h(this, eVar));
            i = i2 + 1;
        }
    }
}
