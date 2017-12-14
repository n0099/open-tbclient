package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class s implements View.OnTouchListener {
    private a gAL;
    private int count = 0;
    private long eQt = 0;
    private long eQu = 0;
    private long eQw = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.s.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                s.this.count = 0;
                s.this.eQt = 0L;
                s.this.eQu = 0L;
            } else if (message.what == 1 && s.this.count == 1) {
                if (s.this.gAL != null) {
                    s.this.gAL.amp();
                }
                s.this.count = 0;
                s.this.eQt = 0L;
                s.this.eQu = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void amp();

        void amq();
    }

    public s(a aVar) {
        this.gAL = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gAL == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eQt = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eQw);
                return true;
            } else if (this.count == 2) {
                this.eQu = System.currentTimeMillis();
                if (this.eQu - this.eQt < this.eQw) {
                    this.gAL.amq();
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
