package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class al implements View.OnTouchListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.c.c cVar;
        cVar = this.djE.bgJ;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
