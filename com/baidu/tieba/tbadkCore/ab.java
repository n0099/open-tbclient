package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ab implements View.OnTouchListener {
    private a dFL;
    private int count = 0;
    private long cDj = 0;
    private long cDk = 0;
    private long cDm = 500;
    private Handler mHandler = new ac(this);

    /* loaded from: classes.dex */
    public interface a {
        void Op();

        void Oq();
    }

    public ab(a aVar) {
        this.dFL = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.dFL == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cDj = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cDm);
                return true;
            } else if (this.count == 2) {
                this.cDk = System.currentTimeMillis();
                if (this.cDk - this.cDj < this.cDm) {
                    this.dFL.Oq();
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
