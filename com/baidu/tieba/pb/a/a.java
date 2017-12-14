package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0126a eQv;
    private int count = 0;
    private long eQt = 0;
    private long eQu = 0;
    private long eQw = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eQt = 0L;
                a.this.eQu = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eQv != null) {
                    a.this.eQv.amp();
                }
                a.this.count = 0;
                a.this.eQt = 0L;
                a.this.eQu = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0126a {
        void amp();

        void amq();
    }

    public a(InterfaceC0126a interfaceC0126a) {
        this.eQv = interfaceC0126a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eQv == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eQt = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eQw);
                return true;
            } else if (this.count == 2) {
                this.eQu = System.currentTimeMillis();
                if (this.eQu - this.eQt < this.eQw) {
                    this.eQv.amq();
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
