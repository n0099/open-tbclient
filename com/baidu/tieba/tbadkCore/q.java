package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    private a giC;
    private int count = 0;
    private long eGM = 0;
    private long eGN = 0;
    private long eGP = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                q.this.count = 0;
                q.this.eGM = 0L;
                q.this.eGN = 0L;
            } else if (message.what == 1 && q.this.count == 1) {
                if (q.this.giC != null) {
                    q.this.giC.ago();
                }
                q.this.count = 0;
                q.this.eGM = 0L;
                q.this.eGN = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ago();

        void agp();
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
                this.eGM = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eGP);
                return true;
            } else if (this.count == 2) {
                this.eGN = System.currentTimeMillis();
                if (this.eGN - this.eGM < this.eGP) {
                    this.giC.agp();
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
