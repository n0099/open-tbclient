package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c bHK;
    private int count = 0;
    private long bHI = 0;
    private long bHJ = 0;
    private long bHL = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.bHK = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bHK == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.bHI = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.bHL);
                return true;
            } else if (this.count == 2) {
                this.bHJ = System.currentTimeMillis();
                if (this.bHJ - this.bHI < this.bHL) {
                    this.bHK.KB();
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
