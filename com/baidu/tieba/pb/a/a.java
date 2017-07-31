package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0107a eES;
    private int count = 0;
    private long eEQ = 0;
    private long eER = 0;
    private long eET = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eEQ = 0L;
                a.this.eER = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eES != null) {
                    a.this.eES.afZ();
                }
                a.this.count = 0;
                a.this.eEQ = 0L;
                a.this.eER = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0107a {
        void afZ();

        void aga();
    }

    public a(InterfaceC0107a interfaceC0107a) {
        this.eES = interfaceC0107a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eES == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eEQ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eET);
                return true;
            } else if (this.count == 2) {
                this.eER = System.currentTimeMillis();
                if (this.eER - this.eEQ < this.eET) {
                    this.eES.aga();
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
