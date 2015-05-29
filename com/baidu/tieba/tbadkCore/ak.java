package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ak implements View.OnTouchListener {
    private am cpS;
    private int count = 0;
    private long bJX = 0;
    private long bJY = 0;
    private long bKa = 500;
    private Handler mHandler = new al(this);

    public ak(am amVar) {
        this.cpS = amVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cpS == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.bJX = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.bKa);
                return true;
            } else if (this.count == 2) {
                this.bJY = System.currentTimeMillis();
                if (this.bJY - this.bJX < this.bKa) {
                    this.cpS.LG();
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
