package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.eSq = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.eSq.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.eSq.dqP) {
                if (this.eSq.mStatus == 1) {
                    i = this.eSq.drd;
                    if (i != 0) {
                        c cVar = this.eSq;
                        i2 = this.eSq.drd;
                        cVar.b(i2 == 1 ? 1000 : -1000, false);
                        this.eSq.drd = 0;
                        this.eSq.drc = 0;
                    }
                }
                if (!this.eSq.aTy.isPlaying() && 8 == this.eSq.aTB.getVisibility()) {
                    this.eSq.aTB.setVisibility(0);
                    this.eSq.eSh.setVisibility(8);
                    this.eSq.eSg.setVisibility(8);
                    this.eSq.eSi.setVisibility(8);
                }
            }
            this.eSq.awk();
            if (this.eSq.eSp != null) {
                this.eSq.eSp.onStop();
            }
        }
        return onTouchEvent;
    }
}
