package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ac implements View.OnTouchListener {
    private a eWq;
    private int count = 0;
    private long dMt = 0;
    private long dMu = 0;
    private long dMw = 500;
    private Handler mHandler = new ad(this);

    /* loaded from: classes.dex */
    public interface a {
        void WO();

        void WP();
    }

    public ac(a aVar) {
        this.eWq = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eWq == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.dMt = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.dMw);
                return true;
            } else if (this.count == 2) {
                this.dMu = System.currentTimeMillis();
                if (this.dMu - this.dMt < this.dMw) {
                    this.eWq.WP();
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
