package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.pb.b.e {
    final /* synthetic */ s bPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.bPU = sVar;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        this.bPU.ee(false);
        this.bPU.O(view);
        this.bPU.ee(true);
        return true;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.bPU.bPS;
        if (!z) {
            this.bPU.adf();
            return true;
        }
        this.bPU.bPS = false;
        return true;
    }
}
