package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    private a gfy;
    private int count = 0;
    private long eDD = 0;
    private long eDE = 0;
    private long eDG = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                q.this.count = 0;
                q.this.eDD = 0L;
                q.this.eDE = 0L;
            } else if (message.what == 1 && q.this.count == 1) {
                if (q.this.gfy != null) {
                    q.this.gfy.afS();
                }
                q.this.count = 0;
                q.this.eDD = 0L;
                q.this.eDE = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void afS();

        void afT();
    }

    public q(a aVar) {
        this.gfy = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gfy == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eDD = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eDG);
                return true;
            } else if (this.count == 2) {
                this.eDE = System.currentTimeMillis();
                if (this.eDE - this.eDD < this.eDG) {
                    this.gfy.afT();
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
