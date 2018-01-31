package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0137a fEW;
    private int count = 0;
    private long fEU = 0;
    private long fEV = 0;
    private long fEX = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fEU = 0L;
                a.this.fEV = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fEW != null) {
                    a.this.fEW.avf();
                }
                a.this.count = 0;
                a.this.fEU = 0L;
                a.this.fEV = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0137a {
        void avf();

        void avg();
    }

    public a(InterfaceC0137a interfaceC0137a) {
        this.fEW = interfaceC0137a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fEW == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fEU = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fEX);
                return true;
            } else if (this.count == 2) {
                this.fEV = System.currentTimeMillis();
                if (this.fEV - this.fEU < this.fEX) {
                    this.fEW.avg();
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
