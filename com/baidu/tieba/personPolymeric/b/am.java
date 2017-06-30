package com.baidu.tieba.personPolymeric.b;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnTouchListener {
    final /* synthetic */ ak eVM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.eVM = akVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        cVar = this.eVM.cfe;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
