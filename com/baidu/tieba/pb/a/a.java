package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0204a ftG;
    private int count = 0;
    private long ftE = 0;
    private long ftF = 0;
    private long ftH = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.ftE = 0L;
                a.this.ftF = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.ftG != null) {
                    a.this.ftG.bai();
                }
                a.this.count = 0;
                a.this.ftE = 0L;
                a.this.ftF = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0204a {
        void bah();

        void bai();
    }

    public a(InterfaceC0204a interfaceC0204a) {
        this.ftG = interfaceC0204a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ftG == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ftE = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ftH);
                return true;
            } else if (this.count == 2) {
                this.ftF = System.currentTimeMillis();
                if (this.ftF - this.ftE < this.ftH) {
                    this.ftG.bah();
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
