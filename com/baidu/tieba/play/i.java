package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.fbb = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.fbb.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.fbb.dwh) {
                if (this.fbb.mStatus == 1) {
                    i = this.fbb.dwv;
                    if (i != 0) {
                        c cVar = this.fbb;
                        i2 = this.fbb.dwv;
                        cVar.c(i2 == 1 ? 1000 : -1000, false);
                        this.fbb.dwv = 0;
                        this.fbb.dwu = 0;
                    }
                }
                if (!this.fbb.bCE.isPlaying() && 8 == this.fbb.bCH.getVisibility()) {
                    this.fbb.bCH.setVisibility(0);
                    this.fbb.faR.setVisibility(8);
                    this.fbb.faQ.setVisibility(8);
                    this.fbb.faS.setVisibility(8);
                }
            }
            this.fbb.axd();
            if (this.fbb.faZ != null) {
                this.fbb.faZ.onStop();
            }
        }
        return onTouchEvent;
    }
}
