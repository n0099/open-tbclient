package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class s implements View.OnTouchListener {
    private a gyc;
    private int count = 0;
    private long ePq = 0;
    private long ePr = 0;
    private long ePt = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.s.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                s.this.count = 0;
                s.this.ePq = 0L;
                s.this.ePr = 0L;
            } else if (message.what == 1 && s.this.count == 1) {
                if (s.this.gyc != null) {
                    s.this.gyc.amg();
                }
                s.this.count = 0;
                s.this.ePq = 0L;
                s.this.ePr = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void amg();

        void amh();
    }

    public s(a aVar) {
        this.gyc = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gyc == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ePq = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ePt);
                return true;
            } else if (this.count == 2) {
                this.ePr = System.currentTimeMillis();
                if (this.ePr - this.ePq < this.ePt) {
                    this.gyc.amh();
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
