package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    private a gog;
    private int count = 0;
    private long eHl = 0;
    private long eHm = 0;
    private long eHo = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.r.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                r.this.count = 0;
                r.this.eHl = 0L;
                r.this.eHm = 0L;
            } else if (message.what == 1 && r.this.count == 1) {
                if (r.this.gog != null) {
                    r.this.gog.ajW();
                }
                r.this.count = 0;
                r.this.eHl = 0L;
                r.this.eHm = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ajW();

        void ajX();
    }

    public r(a aVar) {
        this.gog = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gog == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eHl = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eHo);
                return true;
            } else if (this.count == 2) {
                this.eHm = System.currentTimeMillis();
                if (this.eHm - this.eHl < this.eHo) {
                    this.gog.ajX();
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
