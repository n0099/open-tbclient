package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0349a hkO;
    private int count = 0;
    private long hkM = 0;
    private long hkN = 0;
    private long hkP = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hkM = 0L;
                a.this.hkN = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hkO != null) {
                    a.this.hkO.bII();
                }
                a.this.count = 0;
                a.this.hkM = 0L;
                a.this.hkN = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0349a {
        void bIH();

        void bII();
    }

    public a(InterfaceC0349a interfaceC0349a) {
        this.hkO = interfaceC0349a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hkO == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hkM = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hkP);
                return true;
            } else if (this.count == 2) {
                this.hkN = System.currentTimeMillis();
                if (this.hkN - this.hkM < this.hkP) {
                    this.hkO.bIH();
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
