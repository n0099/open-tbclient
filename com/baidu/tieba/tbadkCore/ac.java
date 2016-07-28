package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ac implements View.OnTouchListener {
    private a fjs;
    private int count = 0;
    private long dYD = 0;
    private long dYE = 0;
    private long dYG = 500;
    private Handler mHandler = new ad(this);

    /* loaded from: classes.dex */
    public interface a {
        void Xg();

        void Xh();
    }

    public ac(a aVar) {
        this.fjs = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fjs == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.dYD = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.dYG);
                return true;
            } else if (this.count == 2) {
                this.dYE = System.currentTimeMillis();
                if (this.dYE - this.dYD < this.dYG) {
                    this.fjs.Xh();
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
