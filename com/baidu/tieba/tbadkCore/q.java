package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    private a ghX;
    private int count = 0;
    private long eGa = 0;
    private long eGb = 0;
    private long eGd = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                q.this.count = 0;
                q.this.eGa = 0L;
                q.this.eGb = 0L;
            } else if (message.what == 1 && q.this.count == 1) {
                if (q.this.ghX != null) {
                    q.this.ghX.ahX();
                }
                q.this.count = 0;
                q.this.eGa = 0L;
                q.this.eGb = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ahX();

        void ahY();
    }

    public q(a aVar) {
        this.ghX = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ghX == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eGa = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eGd);
                return true;
            } else if (this.count == 2) {
                this.eGb = System.currentTimeMillis();
                if (this.eGb - this.eGa < this.eGd) {
                    this.ghX.ahY();
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
