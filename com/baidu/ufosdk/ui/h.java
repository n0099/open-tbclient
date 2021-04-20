package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f22960a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f22961b;

    public h(f fVar, e eVar) {
        this.f22961b = fVar;
        this.f22960a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ey eyVar;
        ey eyVar2;
        String b2 = this.f22960a.b();
        for (int i = 0; i < this.f22961b.f22944c.getChildCount(); i++) {
            View childAt = this.f22961b.f22944c.getChildAt(i);
            if (childAt instanceof e) {
                e eVar = (e) childAt;
                if (eVar.b().equals(b2)) {
                    eVar.a(true);
                } else {
                    eVar.a(false);
                }
            }
        }
        for (int i2 = 0; i2 < this.f22961b.f22943b.getChildCount(); i2++) {
            View childAt2 = this.f22961b.f22943b.getChildAt(i2);
            if (childAt2 instanceof e) {
                ((e) childAt2).a(false);
            }
        }
        eyVar = this.f22961b.f22948g;
        if (eyVar != null) {
            eyVar2 = this.f22961b.f22948g;
            eyVar2.a(b2);
        }
    }
}
