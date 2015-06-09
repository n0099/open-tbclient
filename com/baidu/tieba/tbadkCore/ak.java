package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ak implements View.OnTouchListener {
    private am cpT;
    private int count = 0;
    private long bJY = 0;
    private long bJZ = 0;
    private long bKb = 500;
    private Handler mHandler = new al(this);

    public ak(am amVar) {
        this.cpT = amVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cpT == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.bJY = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.bKb);
                return true;
            } else if (this.count == 2) {
                this.bJZ = System.currentTimeMillis();
                if (this.bJZ - this.bJY < this.bKb) {
                    this.cpT.LH();
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
