package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    private a cXG;
    private int count = 0;
    private long cgr = 0;
    private long cgs = 0;
    private long cgu = 500;
    private Handler mHandler = new ab(this);

    /* loaded from: classes.dex */
    public interface a {
        void Mi();

        void Mj();
    }

    public aa(a aVar) {
        this.cXG = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cXG == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cgr = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cgu);
                return true;
            } else if (this.count == 2) {
                this.cgs = System.currentTimeMillis();
                if (this.cgs - this.cgr < this.cgu) {
                    this.cXG.Mj();
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
