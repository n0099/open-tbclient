package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ l bqB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bqB = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.bqB.bqA;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.bqB.V((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                case 1:
                    this.bqB.Uv();
                    break;
                case 2:
                    if (motionEvent.findPointerIndex(0) != -1) {
                        this.bqB.U((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
