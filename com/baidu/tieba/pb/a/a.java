package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0108a eGM;
    private int count = 0;
    private long eGK = 0;
    private long eGL = 0;
    private long eGN = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eGK = 0L;
                a.this.eGL = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eGM != null) {
                    a.this.eGM.agu();
                }
                a.this.count = 0;
                a.this.eGK = 0L;
                a.this.eGL = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0108a {
        void agu();

        void agv();
    }

    public a(InterfaceC0108a interfaceC0108a) {
        this.eGM = interfaceC0108a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eGM == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eGK = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eGN);
                return true;
            } else if (this.count == 2) {
                this.eGL = System.currentTimeMillis();
                if (this.eGL - this.eGK < this.eGN) {
                    this.eGM.agv();
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
