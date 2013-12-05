package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements com.baidu.tieba.c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.f2214a = crVar;
    }

    @Override // com.baidu.tieba.c.b
    public boolean a(View view, MotionEvent motionEvent) {
        this.f2214a.k(false);
        this.f2214a.b(view);
        this.f2214a.k(true);
        return true;
    }

    @Override // com.baidu.tieba.c.b
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.c.b
    public boolean c(View view, MotionEvent motionEvent) {
        return false;
    }
}
