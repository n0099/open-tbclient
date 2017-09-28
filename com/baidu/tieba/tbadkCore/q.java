package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    private a gfF;
    private int count = 0;
    private long ezw = 0;
    private long ezx = 0;
    private long ezz = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.q.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                q.this.count = 0;
                q.this.ezw = 0L;
                q.this.ezx = 0L;
            } else if (message.what == 1 && q.this.count == 1) {
                if (q.this.gfF != null) {
                    q.this.gfF.ahT();
                }
                q.this.count = 0;
                q.this.ezw = 0L;
                q.this.ezx = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ahT();

        void ahU();
    }

    public q(a aVar) {
        this.gfF = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gfF == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ezw = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ezz);
                return true;
            } else if (this.count == 2) {
                this.ezx = System.currentTimeMillis();
                if (this.ezx - this.ezw < this.ezz) {
                    this.gfF.ahU();
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
