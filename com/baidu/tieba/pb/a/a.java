package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0568a iCW;
    private int count = 0;
    private long iCU = 0;
    private long iCV = 0;
    private long iCX = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.iCU = 0L;
                a.this.iCV = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.iCW != null) {
                    a.this.iCW.clm();
                }
                a.this.count = 0;
                a.this.iCU = 0L;
                a.this.iCV = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0568a {
        void cll();

        void clm();
    }

    public a(InterfaceC0568a interfaceC0568a) {
        this.iCW = interfaceC0568a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.iCW == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.iCU = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.iCX);
                return true;
            } else if (this.count == 2) {
                this.iCV = System.currentTimeMillis();
                if (this.iCV - this.iCU < this.iCX) {
                    this.iCW.cll();
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
