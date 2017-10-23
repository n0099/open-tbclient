package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    private a gfq;
    private int count = 0;
    private long ezi = 0;
    private long ezj = 0;
    private long ezl = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                q.this.count = 0;
                q.this.ezi = 0L;
                q.this.ezj = 0L;
            } else if (message.what == 1 && q.this.count == 1) {
                if (q.this.gfq != null) {
                    q.this.gfq.ahO();
                }
                q.this.count = 0;
                q.this.ezi = 0L;
                q.this.ezj = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ahO();

        void ahP();
    }

    public q(a aVar) {
        this.gfq = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gfq == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ezi = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ezl);
                return true;
            } else if (this.count == 2) {
                this.ezj = System.currentTimeMillis();
                if (this.ezj - this.ezi < this.ezl) {
                    this.gfq.ahP();
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
