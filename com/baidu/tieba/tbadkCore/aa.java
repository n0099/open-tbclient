package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    private a cQn;
    private int count = 0;
    private long cbm = 0;
    private long cbn = 0;
    private long cbp = 500;
    private Handler mHandler = new ab(this);

    /* loaded from: classes.dex */
    public interface a {
        void Mj();

        void Mk();
    }

    public aa(a aVar) {
        this.cQn = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cQn == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cbm = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cbp);
                return true;
            } else if (this.count == 2) {
                this.cbn = System.currentTimeMillis();
                if (this.cbn - this.cbm < this.cbp) {
                    this.cQn.Mk();
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
