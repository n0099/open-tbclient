package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f22924a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f22925b;

    public g(f fVar, e eVar) {
        this.f22925b = fVar;
        this.f22924a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ey eyVar;
        ey eyVar2;
        String b2 = this.f22924a.b();
        for (int i2 = 0; i2 < this.f22925b.f22909b.getChildCount(); i2++) {
            View childAt = this.f22925b.f22909b.getChildAt(i2);
            if (childAt instanceof e) {
                e eVar = (e) childAt;
                if (eVar.b().equals(b2)) {
                    eVar.a(true);
                } else {
                    eVar.a(false);
                }
            }
        }
        for (int i3 = 0; i3 < this.f22925b.f22910c.getChildCount(); i3++) {
            View childAt2 = this.f22925b.f22910c.getChildAt(i3);
            if (childAt2 instanceof e) {
                ((e) childAt2).a(false);
            }
        }
        eyVar = this.f22925b.f22914g;
        if (eyVar != null) {
            eyVar2 = this.f22925b.f22914g;
            eyVar2.a(b2);
        }
    }
}
