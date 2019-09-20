package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0383a hLv;
    private int count = 0;
    private long hLt = 0;
    private long hLu = 0;
    private long hLw = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hLt = 0L;
                a.this.hLu = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hLv != null) {
                    a.this.hLv.bUp();
                }
                a.this.count = 0;
                a.this.hLt = 0L;
                a.this.hLu = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0383a {
        void bUo();

        void bUp();
    }

    public a(InterfaceC0383a interfaceC0383a) {
        this.hLv = interfaceC0383a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hLv == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hLt = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hLw);
                return true;
            } else if (this.count == 2) {
                this.hLu = System.currentTimeMillis();
                if (this.hLu - this.hLt < this.hLw) {
                    this.hLv.bUo();
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
