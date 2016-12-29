package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnTouchListener {
    final /* synthetic */ c eIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.eIS = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.eIS.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.eIS.cyE && this.eIS.eIy) {
                if (this.eIS.mStatus == 1) {
                    i = this.eIS.eIH;
                    if (i != 0) {
                        c cVar = this.eIS;
                        i2 = this.eIS.eIH;
                        cVar.b(i2 == 1 ? 1000 : -1000, false);
                        this.eIS.eIH = 0;
                        this.eIS.eIG = 0;
                    }
                }
                if (!this.eIS.aNV.isPlaying() && 8 == this.eIS.aNZ.getVisibility()) {
                    this.eIS.aNZ.setVisibility(0);
                }
            }
            this.eIS.aWb();
        }
        return onTouchEvent;
    }
}
