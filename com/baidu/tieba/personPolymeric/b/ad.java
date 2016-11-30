package com.baidu.tieba.personPolymeric.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnTouchListener {
    final /* synthetic */ ab eQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.eQt = abVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.d.c cVar;
        cVar = this.eQt.bVF;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
