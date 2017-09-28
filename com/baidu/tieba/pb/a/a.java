package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0110a ezy;
    private int count = 0;
    private long ezw = 0;
    private long ezx = 0;
    private long ezz = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.ezw = 0L;
                a.this.ezx = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.ezy != null) {
                    a.this.ezy.ahT();
                }
                a.this.count = 0;
                a.this.ezw = 0L;
                a.this.ezx = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110a {
        void ahT();

        void ahU();
    }

    public a(InterfaceC0110a interfaceC0110a) {
        this.ezy = interfaceC0110a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ezy == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ezw = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ezz);
                return true;
            } else if (this.count == 2) {
                this.ezx = System.currentTimeMillis();
                if (this.ezx - this.ezw < this.ezz) {
                    this.ezy.ahU();
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
