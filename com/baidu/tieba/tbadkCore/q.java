package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    private a ghd;
    private int count = 0;
    private long eFg = 0;
    private long eFh = 0;
    private long eFj = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                q.this.count = 0;
                q.this.eFg = 0L;
                q.this.eFh = 0L;
            } else if (message.what == 1 && q.this.count == 1) {
                if (q.this.ghd != null) {
                    q.this.ghd.ahM();
                }
                q.this.count = 0;
                q.this.eFg = 0L;
                q.this.eFh = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ahM();

        void ahN();
    }

    public q(a aVar) {
        this.ghd = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ghd == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eFg = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eFj);
                return true;
            } else if (this.count == 2) {
                this.eFh = System.currentTimeMillis();
                if (this.eFh - this.eFg < this.eFj) {
                    this.ghd.ahN();
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
