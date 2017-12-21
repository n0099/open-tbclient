package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class s implements View.OnTouchListener {
    private a gAQ;
    private int count = 0;
    private long eQy = 0;
    private long eQz = 0;
    private long eQB = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.s.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                s.this.count = 0;
                s.this.eQy = 0L;
                s.this.eQz = 0L;
            } else if (message.what == 1 && s.this.count == 1) {
                if (s.this.gAQ != null) {
                    s.this.gAQ.amp();
                }
                s.this.count = 0;
                s.this.eQy = 0L;
                s.this.eQz = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void amp();

        void amq();
    }

    public s(a aVar) {
        this.gAQ = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gAQ == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eQy = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eQB);
                return true;
            } else if (this.count == 2) {
                this.eQz = System.currentTimeMillis();
                if (this.eQz - this.eQy < this.eQB) {
                    this.gAQ.amq();
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
