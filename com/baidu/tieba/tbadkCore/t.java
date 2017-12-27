package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    private a hhC;
    private int count = 0;
    private long fCZ = 0;
    private long fDa = 0;
    private long fDc = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.t.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                t.this.count = 0;
                t.this.fCZ = 0L;
                t.this.fDa = 0L;
            } else if (message.what == 1 && t.this.count == 1) {
                if (t.this.hhC != null) {
                    t.this.hhC.atX();
                }
                t.this.count = 0;
                t.this.fCZ = 0L;
                t.this.fDa = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void atX();

        void atY();
    }

    public t(a aVar) {
        this.hhC = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hhC == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fCZ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fDc);
                return true;
            } else if (this.count == 2) {
                this.fDa = System.currentTimeMillis();
                if (this.fDa - this.fCZ < this.fDc) {
                    this.hhC.atY();
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
