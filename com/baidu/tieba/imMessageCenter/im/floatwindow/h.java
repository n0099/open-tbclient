package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ g ceQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.ceQ = gVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.ceQ.ceP;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.ceQ.aB((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                case 1:
                    this.ceQ.acX();
                    break;
                case 2:
                    if (motionEvent.findPointerIndex(0) != -1) {
                        this.ceQ.aA((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
