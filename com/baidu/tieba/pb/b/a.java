package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c bKa;
    private int count = 0;
    private long bJY = 0;
    private long bJZ = 0;
    private long bKb = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.bKa = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bKa == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.bJY = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.bKb);
                return true;
            } else if (this.count == 2) {
                this.bJZ = System.currentTimeMillis();
                if (this.bJZ - this.bJY < this.bKb) {
                    this.bKa.LH();
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
