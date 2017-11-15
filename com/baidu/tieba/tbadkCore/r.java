package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    private a gpj;
    private int count = 0;
    private long eHF = 0;
    private long eHG = 0;
    private long eHI = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tbadkCore.r.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                r.this.count = 0;
                r.this.eHF = 0L;
                r.this.eHG = 0L;
            } else if (message.what == 1 && r.this.count == 1) {
                if (r.this.gpj != null) {
                    r.this.gpj.akk();
                }
                r.this.count = 0;
                r.this.eHF = 0L;
                r.this.eHG = 0L;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void akk();

        void akl();
    }

    public r(a aVar) {
        this.gpj = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.gpj == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eHF = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eHI);
                return true;
            } else if (this.count == 2) {
                this.eHG = System.currentTimeMillis();
                if (this.eHG - this.eHF < this.eHI) {
                    this.gpj.akl();
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
