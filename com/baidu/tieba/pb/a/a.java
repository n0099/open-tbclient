package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0758a kGW;
    private int count = 0;
    private long kGU = 0;
    private long kGV = 0;
    private long kGX = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.kGU = 0L;
                a.this.kGV = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.kGW != null) {
                    a.this.kGW.cZS();
                }
                a.this.count = 0;
                a.this.kGU = 0L;
                a.this.kGV = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0758a {
        void cZR();

        void cZS();
    }

    public a(InterfaceC0758a interfaceC0758a) {
        this.kGW = interfaceC0758a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.kGW == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.kGU = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.kGX);
                return true;
            } else if (this.count == 2) {
                this.kGV = System.currentTimeMillis();
                if (this.kGV - this.kGU < this.kGX) {
                    this.kGW.cZR();
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
