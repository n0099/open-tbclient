package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    private a gXd;
    private int count = 0;
    private long fEz = 0;
    private long fEA = 0;
    private long fEC = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.t.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                t.this.count = 0;
                t.this.fEz = 0L;
                t.this.fEA = 0L;
            } else if (message.what == 1 && t.this.count == 1) {
                if (t.this.gXd != null) {
                    t.this.gXd.ava();
                }
                t.this.count = 0;
                t.this.fEz = 0L;
                t.this.fEA = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ava();

        void avb();
    }

    public t(a aVar) {
        this.gXd = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gXd == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fEz = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fEC);
                return true;
            } else if (this.count == 2) {
                this.fEA = System.currentTimeMillis();
                if (this.fEA - this.fEz < this.fEC) {
                    this.gXd.avb();
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
