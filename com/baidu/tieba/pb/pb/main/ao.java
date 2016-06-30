package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnTouchListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.dPF.bCX;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
