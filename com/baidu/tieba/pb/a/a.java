package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0109a eGc;
    private int count = 0;
    private long eGa = 0;
    private long eGb = 0;
    private long eGd = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eGa = 0L;
                a.this.eGb = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eGc != null) {
                    a.this.eGc.ahX();
                }
                a.this.count = 0;
                a.this.eGa = 0L;
                a.this.eGb = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109a {
        void ahX();

        void ahY();
    }

    public a(InterfaceC0109a interfaceC0109a) {
        this.eGc = interfaceC0109a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eGc == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eGa = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eGd);
                return true;
            } else if (this.count == 2) {
                this.eGb = System.currentTimeMillis();
                if (this.eGb - this.eGa < this.eGd) {
                    this.eGc.ahY();
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
