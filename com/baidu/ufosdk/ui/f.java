package com.baidu.ufosdk.ui;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout.LayoutParams f22942a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f22943b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f22944c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f22945d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f22946e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Context f22947f;

    /* renamed from: g  reason: collision with root package name */
    public ey f22948g;

    public f(ArrayList arrayList, Context context, ey eyVar) {
        this.f22947f = context;
        this.f22948g = eyVar;
        a(arrayList);
    }

    private void a(ArrayList arrayList) {
        int i = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            (i2 % 2 == 1 ? this.f22945d : this.f22946e).add(arrayList.get(i));
            i = i2;
        }
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f22947f);
        this.f22943b = linearLayout;
        linearLayout.setOrientation(1);
        this.f22943b.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22942a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22947f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22947f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22947f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22947f, 14.0f));
        for (int i = 0; i < this.f22945d.size(); i++) {
            e eVar = new e(this.f22947f);
            eVar.a();
            eVar.a((String) this.f22945d.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22943b.addView(eVar, this.f22942a);
            eVar.setOnClickListener(new g(this, eVar));
        }
        return this.f22943b;
    }

    public final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.f22947f);
        this.f22944c = linearLayout;
        linearLayout.setOrientation(1);
        this.f22944c.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f22942a = layoutParams;
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22947f, 5.0f), com.baidu.ufosdk.f.i.a(this.f22947f, 2.0f), com.baidu.ufosdk.f.i.a(this.f22947f, 15.0f), com.baidu.ufosdk.f.i.a(this.f22947f, 14.0f));
        for (int i = 0; i < this.f22946e.size(); i++) {
            e eVar = new e(this.f22947f);
            eVar.a();
            eVar.a((String) this.f22946e.get(i));
            eVar.a(com.baidu.ufosdk.b.U);
            this.f22944c.addView(eVar, this.f22942a);
            eVar.setOnClickListener(new h(this, eVar));
        }
        return this.f22944c;
    }
}
