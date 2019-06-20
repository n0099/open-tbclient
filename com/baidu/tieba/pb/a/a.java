package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0367a hCs;
    private int count = 0;
    private long hCq = 0;
    private long hCr = 0;
    private long hCt = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hCq = 0L;
                a.this.hCr = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hCs != null) {
                    a.this.hCs.bQD();
                }
                a.this.count = 0;
                a.this.hCq = 0L;
                a.this.hCr = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0367a {
        void bQC();

        void bQD();
    }

    public a(InterfaceC0367a interfaceC0367a) {
        this.hCs = interfaceC0367a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hCs == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hCq = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hCt);
                return true;
            } else if (this.count == 2) {
                this.hCr = System.currentTimeMillis();
                if (this.hCr - this.hCq < this.hCt) {
                    this.hCs.bQC();
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
