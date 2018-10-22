package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0241a fIL;
    private int count = 0;
    private long fIJ = 0;
    private long fIK = 0;
    private long fIM = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fIJ = 0L;
                a.this.fIK = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fIL != null) {
                    a.this.fIL.bfL();
                }
                a.this.count = 0;
                a.this.fIJ = 0L;
                a.this.fIK = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0241a {
        void bfK();

        void bfL();
    }

    public a(InterfaceC0241a interfaceC0241a) {
        this.fIL = interfaceC0241a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fIL == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fIJ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fIM);
                return true;
            } else if (this.count == 2) {
                this.fIK = System.currentTimeMillis();
                if (this.fIK - this.fIJ < this.fIM) {
                    this.fIL.bfK();
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
