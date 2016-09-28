package com.baidu.tieba.personPolymeric.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnTouchListener {
    final /* synthetic */ ab eJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.eJU = abVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.eJU.bPA;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
