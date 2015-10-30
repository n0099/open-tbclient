package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    private a cYg;
    private int count = 0;
    private long cgC = 0;
    private long cgD = 0;
    private long cgF = 500;
    private Handler mHandler = new ab(this);

    /* loaded from: classes.dex */
    public interface a {
        void Me();

        void Mf();
    }

    public aa(a aVar) {
        this.cYg = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cYg == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cgC = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cgF);
                return true;
            } else if (this.count == 2) {
                this.cgD = System.currentTimeMillis();
                if (this.cgD - this.cgC < this.cgF) {
                    this.cYg.Mf();
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
