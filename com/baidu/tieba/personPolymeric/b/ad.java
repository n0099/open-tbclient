package com.baidu.tieba.personPolymeric.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnTouchListener {
    final /* synthetic */ ab eCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.eCS = abVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.eCS.bRf;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
