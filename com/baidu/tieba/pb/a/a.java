package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0279a fUP;
    private int count = 0;
    private long fUN = 0;
    private long fUO = 0;
    private long fUQ = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fUN = 0L;
                a.this.fUO = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fUP != null) {
                    a.this.fUP.bio();
                }
                a.this.count = 0;
                a.this.fUN = 0L;
                a.this.fUO = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0279a {
        void bin();

        void bio();
    }

    public a(InterfaceC0279a interfaceC0279a) {
        this.fUP = interfaceC0279a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fUP == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fUN = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fUQ);
                return true;
            } else if (this.count == 2) {
                this.fUO = System.currentTimeMillis();
                if (this.fUO - this.fUN < this.fUQ) {
                    this.fUP.bin();
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
