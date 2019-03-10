package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0277a hlb;
    private int count = 0;
    private long hkZ = 0;
    private long hla = 0;
    private long hlc = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hkZ = 0L;
                a.this.hla = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hlb != null) {
                    a.this.hlb.bIM();
                }
                a.this.count = 0;
                a.this.hkZ = 0L;
                a.this.hla = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0277a {
        void bIL();

        void bIM();
    }

    public a(InterfaceC0277a interfaceC0277a) {
        this.hlb = interfaceC0277a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hlb == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hkZ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hlc);
                return true;
            } else if (this.count == 2) {
                this.hla = System.currentTimeMillis();
                if (this.hla - this.hkZ < this.hlc) {
                    this.hlb.bIL();
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
