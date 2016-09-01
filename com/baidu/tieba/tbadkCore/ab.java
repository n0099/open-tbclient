package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ab implements View.OnTouchListener {
    private a frk;
    private int count = 0;
    private long ekH = 0;
    private long ekI = 0;
    private long ekK = 500;
    private Handler mHandler = new ac(this);

    /* loaded from: classes.dex */
    public interface a {
        void acd();

        void ace();
    }

    public ab(a aVar) {
        this.frk = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.frk == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ekH = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ekK);
                return true;
            } else if (this.count == 2) {
                this.ekI = System.currentTimeMillis();
                if (this.ekI - this.ekH < this.ekK) {
                    this.frk.ace();
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
