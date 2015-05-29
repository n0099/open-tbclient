package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.pb.b.e {
    final /* synthetic */ s bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.bPT = sVar;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean a(View view, MotionEvent motionEvent) {
        this.bPT.ee(false);
        this.bPT.O(view);
        this.bPT.ee(true);
        return true;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.pb.b.e
    public boolean c(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.bPT.bPR;
        if (!z) {
            this.bPT.ade();
            return true;
        }
        this.bPT.bPR = false;
        return true;
    }
}
