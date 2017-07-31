package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    private a ggJ;
    private int count = 0;
    private long eEQ = 0;
    private long eER = 0;
    private long eET = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                q.this.count = 0;
                q.this.eEQ = 0L;
                q.this.eER = 0L;
            } else if (message.what == 1 && q.this.count == 1) {
                if (q.this.ggJ != null) {
                    q.this.ggJ.afZ();
                }
                q.this.count = 0;
                q.this.eEQ = 0L;
                q.this.eER = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void afZ();

        void aga();
    }

    public q(a aVar) {
        this.ggJ = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ggJ == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eEQ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eET);
                return true;
            } else if (this.count == 2) {
                this.eER = System.currentTimeMillis();
                if (this.eER - this.eEQ < this.eET) {
                    this.ggJ.aga();
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
