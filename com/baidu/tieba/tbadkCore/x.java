package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    private a fxb;
    private int count = 0;
    private long eiT = 0;
    private long eiU = 0;
    private long eiW = 500;
    private Handler mHandler = new y(this);

    /* loaded from: classes.dex */
    public interface a {
        void abt();

        void abu();
    }

    public x(a aVar) {
        this.fxb = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fxb == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eiT = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eiW);
                return true;
            } else if (this.count == 2) {
                this.eiU = System.currentTimeMillis();
                if (this.eiU - this.eiT < this.eiW) {
                    this.fxb.abu();
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
