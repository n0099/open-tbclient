package com.baidu.ufosdk.ui;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f3875a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, e eVar) {
        this.b = fVar;
        this.f3875a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ey eyVar;
        ey eyVar2;
        String b = this.f3875a.b();
        for (int i = 0; i < this.b.b.getChildCount(); i++) {
            View childAt = this.b.b.getChildAt(i);
            if (childAt instanceof e) {
                if (((e) childAt).b().equals(b)) {
                    ((e) childAt).a(true);
                } else {
                    ((e) childAt).a(false);
                }
            }
        }
        for (int i2 = 0; i2 < this.b.c.getChildCount(); i2++) {
            View childAt2 = this.b.c.getChildAt(i2);
            if (childAt2 instanceof e) {
                ((e) childAt2).a(false);
            }
        }
        eyVar = this.b.g;
        if (eyVar != null) {
            eyVar2 = this.b.g;
            eyVar2.a(b);
        }
    }
}
