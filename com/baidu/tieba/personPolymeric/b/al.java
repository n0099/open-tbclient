package com.baidu.tieba.personPolymeric.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnTouchListener {
    final /* synthetic */ aj eLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.eLE = ajVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.eLE.bwH;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
