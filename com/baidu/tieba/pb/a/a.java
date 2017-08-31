package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0110a eFi;
    private int count = 0;
    private long eFg = 0;
    private long eFh = 0;
    private long eFj = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eFg = 0L;
                a.this.eFh = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eFi != null) {
                    a.this.eFi.ahM();
                }
                a.this.count = 0;
                a.this.eFg = 0L;
                a.this.eFh = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110a {
        void ahM();

        void ahN();
    }

    public a(InterfaceC0110a interfaceC0110a) {
        this.eFi = interfaceC0110a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eFi == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eFg = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eFj);
                return true;
            } else if (this.count == 2) {
                this.eFh = System.currentTimeMillis();
                if (this.eFh - this.eFg < this.eFj) {
                    this.eFi.ahN();
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
