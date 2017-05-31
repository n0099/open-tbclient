package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fs implements View.OnTouchListener {
    final /* synthetic */ fr esp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(fr frVar) {
        this.esp = frVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.pb.view.l lVar;
        com.baidu.tieba.pb.view.l lVar2;
        lVar = this.esp.esn;
        if (lVar != null) {
            lVar2 = this.esp.esn;
            return lVar2.onTouch(view, motionEvent);
        }
        return false;
    }
}
