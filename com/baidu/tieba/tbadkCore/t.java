package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    private a gXx;
    private int count = 0;
    private long fEU = 0;
    private long fEV = 0;
    private long fEX = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.t.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                t.this.count = 0;
                t.this.fEU = 0L;
                t.this.fEV = 0L;
            } else if (message.what == 1 && t.this.count == 1) {
                if (t.this.gXx != null) {
                    t.this.gXx.avf();
                }
                t.this.count = 0;
                t.this.fEU = 0L;
                t.this.fEV = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void avf();

        void avg();
    }

    public t(a aVar) {
        this.gXx = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gXx == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fEU = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fEX);
                return true;
            } else if (this.count == 2) {
                this.fEV = System.currentTimeMillis();
                if (this.fEV - this.fEU < this.fEX) {
                    this.gXx.avg();
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
