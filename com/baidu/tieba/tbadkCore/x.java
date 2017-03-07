package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    private a ftb;
    private int count = 0;
    private long eiw = 0;
    private long eix = 0;
    private long eiz = 500;
    private Handler mHandler = new y(this);

    /* loaded from: classes.dex */
    public interface a {
        void ZU();

        void ZV();
    }

    public x(a aVar) {
        this.ftb = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ftb == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eiw = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eiz);
                return true;
            } else if (this.count == 2) {
                this.eix = System.currentTimeMillis();
                if (this.eix - this.eiw < this.eiz) {
                    this.ftb.ZV();
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
