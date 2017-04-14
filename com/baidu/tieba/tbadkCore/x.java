package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    private a fuL;
    private int count = 0;
    private long egD = 0;
    private long egE = 0;
    private long egG = 500;
    private Handler mHandler = new y(this);

    /* loaded from: classes.dex */
    public interface a {
        void aas();

        void aat();
    }

    public x(a aVar) {
        this.fuL = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fuL == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.egD = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.egG);
                return true;
            } else if (this.count == 2) {
                this.egE = System.currentTimeMillis();
                if (this.egE - this.egD < this.egG) {
                    this.fuL.aat();
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
