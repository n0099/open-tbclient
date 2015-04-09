package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.pb.b.e {
    final /* synthetic */ l bOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bOv = lVar;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        this.bOv.dR(false);
        this.bOv.L(view);
        this.bOv.dR(true);
        return true;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.bOv.bOt;
        if (!z) {
            this.bOv.acB();
            return true;
        }
        this.bOv.bOt = false;
        return true;
    }
}
