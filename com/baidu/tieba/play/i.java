package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.eWb = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.eWb.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.eWb.dxS) {
                if (this.eWb.mStatus == 1) {
                    i = this.eWb.dyg;
                    if (i != 0) {
                        c cVar = this.eWb;
                        i2 = this.eWb.dyg;
                        cVar.b(i2 == 1 ? 1000 : -1000, false);
                        this.eWb.dyg = 0;
                        this.eWb.dyf = 0;
                    }
                }
                if (!this.eWb.aSL.isPlaying() && 8 == this.eWb.aSP.getVisibility()) {
                    this.eWb.aSP.setVisibility(0);
                    this.eWb.eVS.setVisibility(8);
                    this.eWb.eVR.setVisibility(8);
                    this.eWb.eVT.setVisibility(8);
                }
            }
            this.eWb.ayI();
            if (this.eWb.eWa != null) {
                this.eWb.eWa.onStop();
            }
        }
        return onTouchEvent;
    }
}
