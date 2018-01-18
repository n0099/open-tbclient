package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0136a fEB;
    private int count = 0;
    private long fEz = 0;
    private long fEA = 0;
    private long fEC = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fEz = 0L;
                a.this.fEA = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fEB != null) {
                    a.this.fEB.ava();
                }
                a.this.count = 0;
                a.this.fEz = 0L;
                a.this.fEA = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0136a {
        void ava();

        void avb();
    }

    public a(InterfaceC0136a interfaceC0136a) {
        this.fEB = interfaceC0136a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fEB == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fEz = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fEC);
                return true;
            } else if (this.count == 2) {
                this.fEA = System.currentTimeMillis();
                if (this.fEA - this.fEz < this.fEC) {
                    this.fEB.avb();
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
