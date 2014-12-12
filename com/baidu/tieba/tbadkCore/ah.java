package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ah implements View.OnTouchListener {
    private aj bTd;
    private int count = 0;
    private long aMK = 0;
    private long aML = 0;
    private long aMN = 500;
    private Handler mHandler = new ai(this);

    public ah(aj ajVar) {
        this.bTd = ajVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bTd == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.aMK = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.aMN);
                return true;
            } else if (this.count == 2) {
                this.aML = System.currentTimeMillis();
                if (this.aML - this.aMK < this.aMN) {
                    this.bTd.GS();
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
