package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements com.baidu.tieba.c.e {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(bv bvVar) {
        this.byW = bvVar;
    }

    @Override // com.baidu.tieba.c.e
    public boolean a(View view, MotionEvent motionEvent) {
        this.byW.ef(false);
        this.byW.V(view);
        this.byW.ef(true);
        return true;
    }

    @Override // com.baidu.tieba.c.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.c.e
    public boolean c(View view, MotionEvent motionEvent) {
        this.byW.Xk();
        this.byW.Yg();
        return false;
    }
}
