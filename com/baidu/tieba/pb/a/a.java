package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0111a ePs;
    private int count = 0;
    private long ePq = 0;
    private long ePr = 0;
    private long ePt = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.ePq = 0L;
                a.this.ePr = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.ePs != null) {
                    a.this.ePs.amg();
                }
                a.this.count = 0;
                a.this.ePq = 0L;
                a.this.ePr = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0111a {
        void amg();

        void amh();
    }

    public a(InterfaceC0111a interfaceC0111a) {
        this.ePs = interfaceC0111a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ePs == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ePq = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ePt);
                return true;
            } else if (this.count == 2) {
                this.ePr = System.currentTimeMillis();
                if (this.ePr - this.ePq < this.ePt) {
                    this.ePs.amh();
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
