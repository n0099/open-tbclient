package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ l bqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bqR = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.bqR.bqQ;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.bqR.V((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                case 1:
                    this.bqR.UI();
                    break;
                case 2:
                    if (motionEvent.findPointerIndex(0) != -1) {
                        this.bqR.U((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
