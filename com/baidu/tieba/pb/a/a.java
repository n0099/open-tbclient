package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0268a fKj;
    private int count = 0;
    private long fKh = 0;
    private long fKi = 0;
    private long fKk = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fKh = 0L;
                a.this.fKi = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fKj != null) {
                    a.this.fKj.bfi();
                }
                a.this.count = 0;
                a.this.fKh = 0L;
                a.this.fKi = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0268a {
        void bfh();

        void bfi();
    }

    public a(InterfaceC0268a interfaceC0268a) {
        this.fKj = interfaceC0268a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fKj == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fKh = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fKk);
                return true;
            } else if (this.count == 2) {
                this.fKi = System.currentTimeMillis();
                if (this.fKi - this.fKh < this.fKk) {
                    this.fKj.bfh();
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
