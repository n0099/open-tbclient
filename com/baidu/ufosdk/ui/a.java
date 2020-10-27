package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public final class a {
    private Context c;
    private d e;
    private int f = 0;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f3738a = new ArrayList();
    private ArrayList b = new ArrayList();
    private ArrayList d = new ArrayList();

    public a(ArrayList arrayList, Context context, d dVar) {
        this.c = context;
        this.e = dVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if ((i + 1) % 2 == 1) {
                this.f3738a.add(arrayList.get(i));
            } else {
                this.b.add(arrayList.get(i));
            }
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.c, 15.0f), com.baidu.ufosdk.f.i.a(this.c, 2.0f), com.baidu.ufosdk.f.i.a(this.c, 15.0f), com.baidu.ufosdk.f.i.a(this.c, 14.0f));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3738a.size()) {
                return linearLayout;
            }
            e eVar = new e(this.c);
            eVar.a();
            eVar.a((String) this.f3738a.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new b(this, eVar));
            i = i2 + 1;
        }
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.c);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.c, 5.0f), com.baidu.ufosdk.f.i.a(this.c, 2.0f), com.baidu.ufosdk.f.i.a(this.c, 15.0f), com.baidu.ufosdk.f.i.a(this.c, 14.0f));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return linearLayout;
            }
            e eVar = new e(this.c);
            eVar.a();
            eVar.a((String) this.b.get(i2));
            eVar.a(com.baidu.ufosdk.b.U);
            linearLayout.addView(eVar, layoutParams);
            eVar.setOnClickListener(new c(this, eVar));
            i = i2 + 1;
        }
    }

    public final ArrayList c() {
        return this.d;
    }
}
