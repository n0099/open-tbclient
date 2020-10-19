package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0776a kWh;
    private int count = 0;
    private long kWf = 0;
    private long kWg = 0;
    private long kWi = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.kWf = 0L;
                a.this.kWg = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.kWh != null) {
                    a.this.kWh.ddB();
                }
                a.this.count = 0;
                a.this.kWf = 0L;
                a.this.kWg = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0776a {
        void ddA();

        void ddB();
    }

    public a(InterfaceC0776a interfaceC0776a) {
        this.kWh = interfaceC0776a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.kWh == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.kWf = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.kWi);
                return true;
            } else if (this.count == 2) {
                this.kWg = System.currentTimeMillis();
                if (this.kWg - this.kWf < this.kWi) {
                    this.kWh.ddA();
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
