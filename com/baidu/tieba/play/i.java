package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.eWq = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.eWq.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.eWq.dwG) {
                if (this.eWq.mStatus == 1) {
                    i = this.eWq.dwU;
                    if (i != 0) {
                        c cVar = this.eWq;
                        i2 = this.eWq.dwU;
                        cVar.b(i2 == 1 ? 1000 : -1000, false);
                        this.eWq.dwU = 0;
                        this.eWq.dwT = 0;
                    }
                }
                if (!this.eWq.aTd.isPlaying() && 8 == this.eWq.aTg.getVisibility()) {
                    this.eWq.aTg.setVisibility(0);
                    this.eWq.eWh.setVisibility(8);
                    this.eWq.eWg.setVisibility(8);
                    this.eWq.eWi.setVisibility(8);
                }
            }
            this.eWq.azn();
            if (this.eWq.eWp != null) {
                this.eWq.eWp.onStop();
            }
        }
        return onTouchEvent;
    }
}
