package com.baidu.tieba.recommendfrs.control;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    final /* synthetic */ q dZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.dZi = qVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.c.c cVar;
        cVar = this.dZi.dZf;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
