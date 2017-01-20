package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.eSu = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.eSu.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.eSu.dvu) {
                if (this.eSu.mStatus == 1) {
                    i = this.eSu.dvI;
                    if (i != 0) {
                        c cVar = this.eSu;
                        i2 = this.eSu.dvI;
                        cVar.b(i2 == 1 ? 1000 : -1000, false);
                        this.eSu.dvI = 0;
                        this.eSu.dvH = 0;
                    }
                }
                if (!this.eSu.aMY.isPlaying() && 8 == this.eSu.aNc.getVisibility()) {
                    this.eSu.aNc.setVisibility(0);
                    this.eSu.eSo.setVisibility(8);
                    this.eSu.eSn.setVisibility(8);
                    this.eSu.eSp.setVisibility(8);
                }
            }
            this.eSu.azm();
        }
        return onTouchEvent;
    }
}
