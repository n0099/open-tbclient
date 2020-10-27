package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0791a liG;
    private int count = 0;
    private long liE = 0;
    private long liF = 0;
    private long liH = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.liE = 0L;
                a.this.liF = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.liG != null) {
                    a.this.liG.dgJ();
                }
                a.this.count = 0;
                a.this.liE = 0L;
                a.this.liF = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0791a {
        void dgI();

        void dgJ();
    }

    public a(InterfaceC0791a interfaceC0791a) {
        this.liG = interfaceC0791a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.liG == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.liE = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.liH);
                return true;
            } else if (this.count == 2) {
                this.liF = System.currentTimeMillis();
                if (this.liF - this.liE < this.liH) {
                    this.liG.dgI();
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
