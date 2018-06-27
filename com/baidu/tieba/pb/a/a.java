package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0205a ftv;
    private int count = 0;
    private long ftt = 0;
    private long ftu = 0;
    private long ftw = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.ftt = 0L;
                a.this.ftu = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.ftv != null) {
                    a.this.ftv.bbP();
                }
                a.this.count = 0;
                a.this.ftt = 0L;
                a.this.ftu = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0205a {
        void bbO();

        void bbP();
    }

    public a(InterfaceC0205a interfaceC0205a) {
        this.ftv = interfaceC0205a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ftv == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ftt = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ftw);
                return true;
            } else if (this.count == 2) {
                this.ftu = System.currentTimeMillis();
                if (this.ftu - this.ftt < this.ftw) {
                    this.ftv.bbO();
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
