package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    private a ffk;
    private int count = 0;
    private long dXe = 0;
    private long dXf = 0;
    private long dXh = 500;
    private Handler mHandler = new ab(this);

    /* loaded from: classes.dex */
    public interface a {
        void XO();

        void XP();
    }

    public aa(a aVar) {
        this.ffk = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ffk == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.dXe = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.dXh);
                return true;
            } else if (this.count == 2) {
                this.dXf = System.currentTimeMillis();
                if (this.dXf - this.dXe < this.dXh) {
                    this.ffk.XP();
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
