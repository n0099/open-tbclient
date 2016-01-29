package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    private a dVG;
    private int count = 0;
    private long cJP = 0;
    private long cJQ = 0;
    private long cJS = 500;
    private Handler mHandler = new ab(this);

    /* loaded from: classes.dex */
    public interface a {
        void Qs();

        void Qt();
    }

    public aa(a aVar) {
        this.dVG = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.dVG == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cJP = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cJS);
                return true;
            } else if (this.count == 2) {
                this.cJQ = System.currentTimeMillis();
                if (this.cJQ - this.cJP < this.cJS) {
                    this.dVG.Qt();
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
