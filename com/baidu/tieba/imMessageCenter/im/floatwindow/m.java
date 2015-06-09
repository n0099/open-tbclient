package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ l btC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.btC = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.btC.btB;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.btC.X((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                case 1:
                    this.btC.Wa();
                    break;
                case 2:
                    if (motionEvent.findPointerIndex(0) != -1) {
                        this.btC.W((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
