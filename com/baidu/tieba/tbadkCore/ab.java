package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class ab implements View.OnTouchListener {
    private a ftS;
    private int count = 0;
    private long emJ = 0;
    private long emK = 0;
    private long emM = 500;
    private Handler mHandler = new ac(this);

    /* loaded from: classes.dex */
    public interface a {
        void acq();

        void acr();
    }

    public ab(a aVar) {
        this.ftS = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ftS == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.emJ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.emM);
                return true;
            } else if (this.count == 2) {
                this.emK = System.currentTimeMillis();
                if (this.emK - this.emJ < this.emM) {
                    this.ftS.acr();
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
