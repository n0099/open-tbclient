package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements com.baidu.tieba.c.e {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(bv bvVar) {
        this.byI = bvVar;
    }

    @Override // com.baidu.tieba.c.e
    public boolean a(View view, MotionEvent motionEvent) {
        this.byI.ef(false);
        this.byI.V(view);
        this.byI.ef(true);
        return true;
    }

    @Override // com.baidu.tieba.c.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.c.e
    public boolean c(View view, MotionEvent motionEvent) {
        this.byI.Xh();
        this.byI.Yd();
        return false;
    }
}
