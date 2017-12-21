package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0125a eQA;
    private int count = 0;
    private long eQy = 0;
    private long eQz = 0;
    private long eQB = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eQy = 0L;
                a.this.eQz = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eQA != null) {
                    a.this.eQA.amp();
                }
                a.this.count = 0;
                a.this.eQy = 0L;
                a.this.eQz = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0125a {
        void amp();

        void amq();
    }

    public a(InterfaceC0125a interfaceC0125a) {
        this.eQA = interfaceC0125a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eQA == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eQy = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eQB);
                return true;
            } else if (this.count == 2) {
                this.eQz = System.currentTimeMillis();
                if (this.eQz - this.eQy < this.eQB) {
                    this.eQA.amq();
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
