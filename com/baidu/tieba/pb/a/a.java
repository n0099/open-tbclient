package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0568a iDi;
    private int count = 0;
    private long iDg = 0;
    private long iDh = 0;
    private long iDj = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.iDg = 0L;
                a.this.iDh = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.iDi != null) {
                    a.this.iDi.cln();
                }
                a.this.count = 0;
                a.this.iDg = 0L;
                a.this.iDh = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0568a {
        void clm();

        void cln();
    }

    public a(InterfaceC0568a interfaceC0568a) {
        this.iDi = interfaceC0568a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.iDi == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.iDg = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.iDj);
                return true;
            } else if (this.count == 2) {
                this.iDh = System.currentTimeMillis();
                if (this.iDh - this.iDg < this.iDj) {
                    this.iDi.clm();
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
