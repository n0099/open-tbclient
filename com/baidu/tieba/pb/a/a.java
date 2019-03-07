package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0277a hla;
    private int count = 0;
    private long hkY = 0;
    private long hkZ = 0;
    private long hlb = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hkY = 0L;
                a.this.hkZ = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hla != null) {
                    a.this.hla.bIL();
                }
                a.this.count = 0;
                a.this.hkY = 0L;
                a.this.hkZ = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0277a {
        void bIK();

        void bIL();
    }

    public a(InterfaceC0277a interfaceC0277a) {
        this.hla = interfaceC0277a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hla == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hkY = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hlb);
                return true;
            } else if (this.count == 2) {
                this.hkZ = System.currentTimeMillis();
                if (this.hkZ - this.hkY < this.hlb) {
                    this.hla.bIK();
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
