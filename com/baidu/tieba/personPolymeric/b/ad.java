package com.baidu.tieba.personPolymeric.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnTouchListener {
    final /* synthetic */ ab eDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.eDM = abVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.f.c cVar;
        cVar = this.eDM.bJg;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
