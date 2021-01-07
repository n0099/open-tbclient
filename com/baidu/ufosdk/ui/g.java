package com.baidu.ufosdk.ui;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f5877a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f5878b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, e eVar) {
        this.f5878b = fVar;
        this.f5877a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ey eyVar;
        ey eyVar2;
        String b2 = this.f5877a.b();
        for (int i = 0; i < this.f5878b.f5869b.getChildCount(); i++) {
            View childAt = this.f5878b.f5869b.getChildAt(i);
            if (childAt instanceof e) {
                if (((e) childAt).b().equals(b2)) {
                    ((e) childAt).a(true);
                } else {
                    ((e) childAt).a(false);
                }
            }
        }
        for (int i2 = 0; i2 < this.f5878b.c.getChildCount(); i2++) {
            View childAt2 = this.f5878b.c.getChildAt(i2);
            if (childAt2 instanceof e) {
                ((e) childAt2).a(false);
            }
        }
        eyVar = this.f5878b.g;
        if (eyVar != null) {
            eyVar2 = this.f5878b.g;
            eyVar2.a(b2);
        }
    }
}
