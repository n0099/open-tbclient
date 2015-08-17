package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {
    private a cHN;
    private int count = 0;
    private long car = 0;
    private long cas = 0;
    private long cau = 500;
    private Handler mHandler = new aa(this);

    /* loaded from: classes.dex */
    public interface a {
        void Ms();

        void Mt();
    }

    public z(a aVar) {
        this.cHN = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cHN == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.car = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cau);
                return true;
            } else if (this.count == 2) {
                this.cas = System.currentTimeMillis();
                if (this.cas - this.car < this.cau) {
                    this.cHN.Mt();
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
