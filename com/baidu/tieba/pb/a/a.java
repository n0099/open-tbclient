package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0241a fIK;
    private int count = 0;
    private long fII = 0;
    private long fIJ = 0;
    private long fIL = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fII = 0L;
                a.this.fIJ = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fIK != null) {
                    a.this.fIK.bfL();
                }
                a.this.count = 0;
                a.this.fII = 0L;
                a.this.fIJ = 0L;
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
        this.fIK = interfaceC0241a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fIK == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fII = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fIL);
                return true;
            } else if (this.count == 2) {
                this.fIJ = System.currentTimeMillis();
                if (this.fIJ - this.fII < this.fIL) {
                    this.fIK.bfK();
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
