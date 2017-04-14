package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnTouchListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.ejU.bQe;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
