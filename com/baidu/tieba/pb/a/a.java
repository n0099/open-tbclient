package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0477a hKb;
    private int count = 0;
    private long hJZ = 0;
    private long hKa = 0;
    private long hKc = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hJZ = 0L;
                a.this.hKa = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hKb != null) {
                    a.this.hKb.bRq();
                }
                a.this.count = 0;
                a.this.hJZ = 0L;
                a.this.hKa = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0477a {
        void bRp();

        void bRq();
    }

    public a(InterfaceC0477a interfaceC0477a) {
        this.hKb = interfaceC0477a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hKb == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hJZ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hKc);
                return true;
            } else if (this.count == 2) {
                this.hKa = System.currentTimeMillis();
                if (this.hKa - this.hJZ < this.hKc) {
                    this.hKb.bRp();
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
