package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c bJZ;
    private int count = 0;
    private long bJX = 0;
    private long bJY = 0;
    private long bKa = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.bJZ = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bJZ == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.bJX = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.bKa);
                return true;
            } else if (this.count == 2) {
                this.bJY = System.currentTimeMillis();
                if (this.bJY - this.bJX < this.bKa) {
                    this.bJZ.LG();
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
