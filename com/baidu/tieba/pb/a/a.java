package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0367a hCr;
    private int count = 0;
    private long hCp = 0;
    private long hCq = 0;
    private long hCs = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hCp = 0L;
                a.this.hCq = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hCr != null) {
                    a.this.hCr.bQC();
                }
                a.this.count = 0;
                a.this.hCp = 0L;
                a.this.hCq = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0367a {
        void bQB();

        void bQC();
    }

    public a(InterfaceC0367a interfaceC0367a) {
        this.hCr = interfaceC0367a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hCr == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hCp = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hCs);
                return true;
            } else if (this.count == 2) {
                this.hCq = System.currentTimeMillis();
                if (this.hCq - this.hCp < this.hCs) {
                    this.hCr.bQB();
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
