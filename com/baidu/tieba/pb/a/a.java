package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0568a iCU;
    private int count = 0;
    private long iCS = 0;
    private long iCT = 0;
    private long iCV = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.iCS = 0L;
                a.this.iCT = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.iCU != null) {
                    a.this.iCU.clk();
                }
                a.this.count = 0;
                a.this.iCS = 0L;
                a.this.iCT = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0568a {
        void clj();

        void clk();
    }

    public a(InterfaceC0568a interfaceC0568a) {
        this.iCU = interfaceC0568a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.iCU == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.iCS = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.iCV);
                return true;
            } else if (this.count == 2) {
                this.iCT = System.currentTimeMillis();
                if (this.iCT - this.iCS < this.iCV) {
                    this.iCU.clj();
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
