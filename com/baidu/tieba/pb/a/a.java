package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0204a ftz;
    private int count = 0;
    private long ftx = 0;
    private long fty = 0;
    private long ftA = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.ftx = 0L;
                a.this.fty = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.ftz != null) {
                    a.this.ftz.bad();
                }
                a.this.count = 0;
                a.this.ftx = 0L;
                a.this.fty = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0204a {
        void bac();

        void bad();
    }

    public a(InterfaceC0204a interfaceC0204a) {
        this.ftz = interfaceC0204a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ftz == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ftx = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ftA);
                return true;
            } else if (this.count == 2) {
                this.fty = System.currentTimeMillis();
                if (this.fty - this.ftx < this.ftA) {
                    this.ftz.bac();
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
