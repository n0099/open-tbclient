package com.baidu.tieba.play;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.flr = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int i;
        int i2;
        gestureDetector = this.flr.mGestureDetector;
        boolean onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            if (this.flr.dEU) {
                if (this.flr.mStatus == 1) {
                    i = this.flr.dFi;
                    if (i != 0) {
                        c cVar = this.flr;
                        i2 = this.flr.dFi;
                        cVar.c(i2 == 1 ? 1000 : -1000, false);
                        this.flr.dFi = 0;
                        this.flr.dFh = 0;
                    }
                }
                if (!this.flr.bDx.isPlaying() && 8 == this.flr.bDA.getVisibility()) {
                    this.flr.bDA.setVisibility(0);
                    this.flr.flh.setVisibility(8);
                    this.flr.flg.setVisibility(8);
                    this.flr.fli.setVisibility(8);
                }
            }
            this.flr.aBc();
            if (this.flr.flp != null) {
                this.flr.flp.onStop();
            }
        }
        return onTouchEvent;
    }
}
