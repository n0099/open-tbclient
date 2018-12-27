package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0279a fTR;
    private int count = 0;
    private long fTP = 0;
    private long fTQ = 0;
    private long fTS = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fTP = 0L;
                a.this.fTQ = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fTR != null) {
                    a.this.fTR.bhK();
                }
                a.this.count = 0;
                a.this.fTP = 0L;
                a.this.fTQ = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0279a {
        void bhJ();

        void bhK();
    }

    public a(InterfaceC0279a interfaceC0279a) {
        this.fTR = interfaceC0279a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fTR == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fTP = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fTS);
                return true;
            } else if (this.count == 2) {
                this.fTQ = System.currentTimeMillis();
                if (this.fTQ - this.fTP < this.fTS) {
                    this.fTR.bhJ();
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
