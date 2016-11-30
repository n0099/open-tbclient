package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ g dvS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dvS = gVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.dvS.dvR;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.dvS.aZ((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                case 1:
                    this.dvS.azS();
                    break;
                case 2:
                    if (motionEvent.findPointerIndex(0) != -1) {
                        this.dvS.aY((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
