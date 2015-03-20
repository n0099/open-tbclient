package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c bHx;
    private int count = 0;
    private long bHv = 0;
    private long bHw = 0;
    private long bHy = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.bHx = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bHx == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.bHv = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.bHy);
                return true;
            } else if (this.count == 2) {
                this.bHw = System.currentTimeMillis();
                if (this.bHw - this.bHv < this.bHy) {
                    this.bHx.Kr();
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
