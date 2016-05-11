package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ab implements View.OnTouchListener {
    private a erC;
    private int count = 0;
    private long dfA = 0;
    private long dfB = 0;
    private long dfD = 500;
    private Handler mHandler = new ac(this);

    /* loaded from: classes.dex */
    public interface a {
        void Rr();

        void Rs();
    }

    public ab(a aVar) {
        this.erC = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.erC == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.dfA = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.dfD);
                return true;
            } else if (this.count == 2) {
                this.dfB = System.currentTimeMillis();
                if (this.dfB - this.dfA < this.dfD) {
                    this.erC.Rs();
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
