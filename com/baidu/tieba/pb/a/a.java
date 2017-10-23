package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0110a ezk;
    private int count = 0;
    private long ezi = 0;
    private long ezj = 0;
    private long ezl = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.ezi = 0L;
                a.this.ezj = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.ezk != null) {
                    a.this.ezk.ahO();
                }
                a.this.count = 0;
                a.this.ezi = 0L;
                a.this.ezj = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110a {
        void ahO();

        void ahP();
    }

    public a(InterfaceC0110a interfaceC0110a) {
        this.ezk = interfaceC0110a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ezk == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ezi = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ezl);
                return true;
            } else if (this.count == 2) {
                this.ezj = System.currentTimeMillis();
                if (this.ezj - this.ezi < this.ezl) {
                    this.ezk.ahP();
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
