package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ g cjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cjp = gVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.cjp.cjo;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.cjp.aC((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                case 1:
                    this.cjp.agg();
                    break;
                case 2:
                    if (motionEvent.findPointerIndex(0) != -1) {
                        this.cjp.aB((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
