package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ g cuS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cuS = gVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.cuS.cuR;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.cuS.ay((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                case 1:
                    this.cuS.ajG();
                    break;
                case 2:
                    if (motionEvent.findPointerIndex(0) != -1) {
                        this.cuS.ax((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                        break;
                    }
                    break;
            }
        }
        return true;
    }
}
