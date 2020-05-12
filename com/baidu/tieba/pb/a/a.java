package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0628a joT;
    private int count = 0;
    private long joR = 0;
    private long joS = 0;
    private long joU = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.joR = 0L;
                a.this.joS = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.joT != null) {
                    a.this.joT.cwm();
                }
                a.this.count = 0;
                a.this.joR = 0L;
                a.this.joS = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0628a {
        void cwl();

        void cwm();
    }

    public a(InterfaceC0628a interfaceC0628a) {
        this.joT = interfaceC0628a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.joT == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.joR = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.joU);
                return true;
            } else if (this.count == 2) {
                this.joS = System.currentTimeMillis();
                if (this.joS - this.joR < this.joU) {
                    this.joT.cwl();
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
