package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ak implements View.OnTouchListener {
    private am clD;
    private int count = 0;
    private long bHv = 0;
    private long bHw = 0;
    private long bHy = 500;
    private Handler mHandler = new al(this);

    public ak(am amVar) {
        this.clD = amVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.clD == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.bHv = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.bHy);
                return true;
            } else if (this.count == 2) {
                this.bHw = System.currentTimeMillis();
                if (this.bHw - this.bHv < this.bHy) {
                    this.clD.Kr();
                }
                this.mHandler.sendEmptyMessage(2);
                return true;
            } else {
                return true;
            }
        }
        return true;
    }
}
