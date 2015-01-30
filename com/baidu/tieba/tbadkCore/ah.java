package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ah implements View.OnTouchListener {
    private aj bUW;
    private int count = 0;
    private long aNT = 0;
    private long aNU = 0;
    private long aNW = 500;
    private Handler mHandler = new ai(this);

    public ah(aj ajVar) {
        this.bUW = ajVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bUW == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.aNT = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.aNW);
                return true;
            } else if (this.count == 2) {
                this.aNU = System.currentTimeMillis();
                if (this.aNU - this.aNT < this.aNW) {
                    this.bUW.Hp();
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
