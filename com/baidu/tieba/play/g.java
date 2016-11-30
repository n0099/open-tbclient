package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnTouchListener {
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.ffA = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.ffA.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.ffA.cTv && this.ffA.feZ) {
                if (this.ffA.mStatus == 1) {
                    i = this.ffA.ffm;
                    if (i != 0) {
                        c cVar = this.ffA;
                        i2 = this.ffA.ffm;
                        cVar.b(i2 == 1 ? 1000 : -1000, false);
                        this.ffA.ffm = 0;
                        this.ffA.ffl = 0;
                    }
                }
                if (!this.ffA.aOE.isPlaying() && 8 == this.ffA.aOI.getVisibility()) {
                    this.ffA.aOI.setVisibility(0);
                }
            }
            this.ffA.bcq();
        }
        return onTouchEvent;
    }
}
