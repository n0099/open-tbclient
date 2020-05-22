package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0681a jFC;
    private int count = 0;
    private long jFA = 0;
    private long jFB = 0;
    private long jFD = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.jFA = 0L;
                a.this.jFB = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.jFC != null) {
                    a.this.jFC.cDj();
                }
                a.this.count = 0;
                a.this.jFA = 0L;
                a.this.jFB = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0681a {
        void cDi();

        void cDj();
    }

    public a(InterfaceC0681a interfaceC0681a) {
        this.jFC = interfaceC0681a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.jFC == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.jFA = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.jFD);
                return true;
            } else if (this.count == 2) {
                this.jFB = System.currentTimeMillis();
                if (this.jFB - this.jFA < this.jFD) {
                    this.jFC.cDi();
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
