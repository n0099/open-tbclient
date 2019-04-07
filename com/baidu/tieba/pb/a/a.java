package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0349a hkN;
    private int count = 0;
    private long hkL = 0;
    private long hkM = 0;
    private long hkO = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hkL = 0L;
                a.this.hkM = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hkN != null) {
                    a.this.hkN.bII();
                }
                a.this.count = 0;
                a.this.hkL = 0L;
                a.this.hkM = 0L;
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
        this.hkN = interfaceC0349a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hkN == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hkL = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hkO);
                return true;
            } else if (this.count == 2) {
                this.hkM = System.currentTimeMillis();
                if (this.hkM - this.hkL < this.hkO) {
                    this.hkN.bIH();
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
