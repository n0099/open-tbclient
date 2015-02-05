package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ah implements View.OnTouchListener {
    private aj bUV;
    private int count = 0;
    private long aNS = 0;
    private long aNT = 0;
    private long aNV = 500;
    private Handler mHandler = new ai(this);

    public ah(aj ajVar) {
        this.bUV = ajVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.bUV == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.aNS = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.aNV);
                return true;
            } else if (this.count == 2) {
                this.aNT = System.currentTimeMillis();
                if (this.aNT - this.aNS < this.aNV) {
                    this.bUV.Hj();
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
