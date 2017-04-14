package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.eUa = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.eUa.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.eUa.dup) {
                if (this.eUa.mStatus == 1) {
                    i = this.eUa.duD;
                    if (i != 0) {
                        c cVar = this.eUa;
                        i2 = this.eUa.duD;
                        cVar.b(i2 == 1 ? 1000 : -1000, false);
                        this.eUa.duD = 0;
                        this.eUa.duC = 0;
                    }
                }
                if (!this.eUa.aTb.isPlaying() && 8 == this.eUa.aTe.getVisibility()) {
                    this.eUa.aTe.setVisibility(0);
                    this.eUa.eTR.setVisibility(8);
                    this.eUa.eTQ.setVisibility(8);
                    this.eUa.eTS.setVisibility(8);
                }
            }
            this.eUa.aym();
            if (this.eUa.eTZ != null) {
                this.eUa.eTZ.onStop();
            }
        }
        return onTouchEvent;
    }
}
