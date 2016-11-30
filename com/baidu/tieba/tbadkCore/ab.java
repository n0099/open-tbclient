package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ab implements View.OnTouchListener {
    private a fBf;
    private int count = 0;
    private long esG = 0;
    private long esH = 0;
    private long esJ = 500;
    private Handler mHandler = new ac(this);

    /* loaded from: classes.dex */
    public interface a {
        void adv();

        void adw();
    }

    public ab(a aVar) {
        this.fBf = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fBf == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.esG = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.esJ);
                return true;
            } else if (this.count == 2) {
                this.esH = System.currentTimeMillis();
                if (this.esH - this.esG < this.esJ) {
                    this.fBf.adw();
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
