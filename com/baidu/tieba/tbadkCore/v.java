package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class v implements View.OnTouchListener {
    private a fAX;
    private int count = 0;
    private long ejw = 0;
    private long ejx = 0;
    private long ejz = 500;
    private Handler mHandler = new w(this);

    /* loaded from: classes.dex */
    public interface a {
        void aaX();

        void aaY();
    }

    public v(a aVar) {
        this.fAX = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fAX == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ejw = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ejz);
                return true;
            } else if (this.count == 2) {
                this.ejx = System.currentTimeMillis();
                if (this.ejx - this.ejw < this.ejz) {
                    this.fAX.aaY();
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
