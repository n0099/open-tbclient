package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {
    private a foF;
    private int count = 0;
    private long ega = 0;
    private long egb = 0;
    private long egd = 500;
    private Handler mHandler = new z(this);

    /* loaded from: classes.dex */
    public interface a {
        void YV();

        void YW();
    }

    public y(a aVar) {
        this.foF = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.foF == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ega = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.egd);
                return true;
            } else if (this.count == 2) {
                this.egb = System.currentTimeMillis();
                if (this.egb - this.ega < this.egd) {
                    this.foF.YW();
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
