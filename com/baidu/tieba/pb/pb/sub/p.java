package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.pb.b.e {
    final /* synthetic */ l bOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bOf = lVar;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        this.bOf.dT(false);
        this.bOf.L(view);
        this.bOf.dT(true);
        return true;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.bOf.bOd;
        if (!z) {
            this.bOf.acm();
            return true;
        }
        this.bOf.bOd = false;
        return true;
    }
}
