package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0279a fQZ;
    private int count = 0;
    private long fQX = 0;
    private long fQY = 0;
    private long fRa = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fQX = 0L;
                a.this.fQY = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fQZ != null) {
                    a.this.fQZ.bgY();
                }
                a.this.count = 0;
                a.this.fQX = 0L;
                a.this.fQY = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0279a {
        void bgX();

        void bgY();
    }

    public a(InterfaceC0279a interfaceC0279a) {
        this.fQZ = interfaceC0279a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fQZ == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fQX = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fRa);
                return true;
            } else if (this.count == 2) {
                this.fQY = System.currentTimeMillis();
                if (this.fQY - this.fQX < this.fRa) {
                    this.fQZ.bgX();
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
