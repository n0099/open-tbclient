package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    private a eol;
    private int count = 0;
    private long ddg = 0;
    private long ddh = 0;
    private long ddj = 500;
    private Handler mHandler = new ab(this);

    /* loaded from: classes.dex */
    public interface a {
        void Sl();

        void Sm();
    }

    public aa(a aVar) {
        this.eol = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eol == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ddg = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ddj);
                return true;
            } else if (this.count == 2) {
                this.ddh = System.currentTimeMillis();
                if (this.ddh - this.ddg < this.ddj) {
                    this.eol.Sm();
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
