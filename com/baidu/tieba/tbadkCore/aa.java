package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    private a cZD;
    private int count = 0;
    private long chh = 0;
    private long chi = 0;
    private long chk = 500;
    private Handler mHandler = new ab(this);

    /* loaded from: classes.dex */
    public interface a {
        void Mu();

        void Mv();
    }

    public aa(a aVar) {
        this.cZD = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cZD == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.chh = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.chk);
                return true;
            } else if (this.count == 2) {
                this.chi = System.currentTimeMillis();
                if (this.chi - this.chh < this.chk) {
                    this.cZD.Mv();
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
