package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0561a iBb;
    private int count = 0;
    private long iAZ = 0;
    private long iBa = 0;
    private long iBc = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.iAZ = 0L;
                a.this.iBa = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.iBb != null) {
                    a.this.iBb.cjM();
                }
                a.this.count = 0;
                a.this.iAZ = 0L;
                a.this.iBa = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0561a {
        void cjL();

        void cjM();
    }

    public a(InterfaceC0561a interfaceC0561a) {
        this.iBb = interfaceC0561a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.iBb == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.iAZ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.iBc);
                return true;
            } else if (this.count == 2) {
                this.iBa = System.currentTimeMillis();
                if (this.iBa - this.iAZ < this.iBc) {
                    this.iBb.cjL();
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
