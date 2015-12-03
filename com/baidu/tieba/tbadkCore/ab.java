package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ab implements View.OnTouchListener {
    private a dyr;
    private int count = 0;
    private long czE = 0;
    private long czF = 0;
    private long czH = 500;
    private Handler mHandler = new ac(this);

    /* loaded from: classes.dex */
    public interface a {
        void NW();

        void NX();
    }

    public ab(a aVar) {
        this.dyr = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.dyr == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.czE = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.czH);
                return true;
            } else if (this.count == 2) {
                this.czF = System.currentTimeMillis();
                if (this.czF - this.czE < this.czH) {
                    this.dyr.NX();
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
