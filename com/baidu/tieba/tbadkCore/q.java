package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    private a giC;
    private int count = 0;
    private long eGK = 0;
    private long eGL = 0;
    private long eGN = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                q.this.count = 0;
                q.this.eGK = 0L;
                q.this.eGL = 0L;
            } else if (message.what == 1 && q.this.count == 1) {
                if (q.this.giC != null) {
                    q.this.giC.agu();
                }
                q.this.count = 0;
                q.this.eGK = 0L;
                q.this.eGL = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void agu();

        void agv();
    }

    public q(a aVar) {
        this.giC = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.giC == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eGK = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eGN);
                return true;
            } else if (this.count == 2) {
                this.eGL = System.currentTimeMillis();
                if (this.eGL - this.eGK < this.eGN) {
                    this.giC.agv();
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
