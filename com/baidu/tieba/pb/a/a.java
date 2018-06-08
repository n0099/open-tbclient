package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0203a fpC;
    private int count = 0;
    private long fpA = 0;
    private long fpB = 0;
    private long fpD = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fpA = 0L;
                a.this.fpB = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fpC != null) {
                    a.this.fpC.bbi();
                }
                a.this.count = 0;
                a.this.fpA = 0L;
                a.this.fpB = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0203a {
        void bbh();

        void bbi();
    }

    public a(InterfaceC0203a interfaceC0203a) {
        this.fpC = interfaceC0203a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fpC == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fpA = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fpD);
                return true;
            } else if (this.count == 2) {
                this.fpB = System.currentTimeMillis();
                if (this.fpB - this.fpA < this.fpD) {
                    this.fpC.bbh();
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
