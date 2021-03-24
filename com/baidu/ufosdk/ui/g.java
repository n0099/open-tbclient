package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f23272a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f23273b;

    public g(f fVar, e eVar) {
        this.f23273b = fVar;
        this.f23272a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ey eyVar;
        ey eyVar2;
        String b2 = this.f23272a.b();
        for (int i = 0; i < this.f23273b.f23257b.getChildCount(); i++) {
            View childAt = this.f23273b.f23257b.getChildAt(i);
            if (childAt instanceof e) {
                e eVar = (e) childAt;
                if (eVar.b().equals(b2)) {
                    eVar.a(true);
                } else {
                    eVar.a(false);
                }
            }
        }
        for (int i2 = 0; i2 < this.f23273b.f23258c.getChildCount(); i2++) {
            View childAt2 = this.f23273b.f23258c.getChildAt(i2);
            if (childAt2 instanceof e) {
                ((e) childAt2).a(false);
            }
        }
        eyVar = this.f23273b.f23262g;
        if (eyVar != null) {
            eyVar2 = this.f23273b.f23262g;
            eyVar2.a(b2);
        }
    }
}
