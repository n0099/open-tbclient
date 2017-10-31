package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0109a eHn;
    private int count = 0;
    private long eHl = 0;
    private long eHm = 0;
    private long eHo = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eHl = 0L;
                a.this.eHm = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eHn != null) {
                    a.this.eHn.ajW();
                }
                a.this.count = 0;
                a.this.eHl = 0L;
                a.this.eHm = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109a {
        void ajW();

        void ajX();
    }

    public a(InterfaceC0109a interfaceC0109a) {
        this.eHn = interfaceC0109a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eHn == null) {
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
                    this.eHn.ajX();
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
