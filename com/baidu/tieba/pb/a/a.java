package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0808a loY;
    private int count = 0;
    private long loW = 0;
    private long loX = 0;
    private long loZ = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.loW = 0L;
                a.this.loX = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.loY != null) {
                    a.this.loY.diI();
                }
                a.this.count = 0;
                a.this.loW = 0L;
                a.this.loX = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0808a {
        void diH();

        void diI();
    }

    public a(InterfaceC0808a interfaceC0808a) {
        this.loY = interfaceC0808a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.loY == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.loW = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.loZ);
                return true;
            } else if (this.count == 2) {
                this.loX = System.currentTimeMillis();
                if (this.loX - this.loW < this.loZ) {
                    this.loY.diH();
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
