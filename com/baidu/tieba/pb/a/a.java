package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0607a joP;
    private int count = 0;
    private long joN = 0;
    private long joO = 0;
    private long joQ = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.joN = 0L;
                a.this.joO = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.joP != null) {
                    a.this.joP.cwo();
                }
                a.this.count = 0;
                a.this.joN = 0L;
                a.this.joO = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0607a {
        void cwn();

        void cwo();
    }

    public a(InterfaceC0607a interfaceC0607a) {
        this.joP = interfaceC0607a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.joP == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.joN = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.joQ);
                return true;
            } else if (this.count == 2) {
                this.joO = System.currentTimeMillis();
                if (this.joO - this.joN < this.joQ) {
                    this.joP.cwn();
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
