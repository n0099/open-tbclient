package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0187a fcY;
    private int count = 0;
    private long fcW = 0;
    private long fcX = 0;
    private long fcZ = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fcW = 0L;
                a.this.fcX = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fcY != null) {
                    a.this.fcY.aWm();
                }
                a.this.count = 0;
                a.this.fcW = 0L;
                a.this.fcX = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0187a {
        void aWl();

        void aWm();
    }

    public a(InterfaceC0187a interfaceC0187a) {
        this.fcY = interfaceC0187a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fcY == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fcW = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fcZ);
                return true;
            } else if (this.count == 2) {
                this.fcX = System.currentTimeMillis();
                if (this.fcX - this.fcW < this.fcZ) {
                    this.fcY.aWl();
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
