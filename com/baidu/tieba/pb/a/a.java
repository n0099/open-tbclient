package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0682a jGI;
    private int count = 0;
    private long jGG = 0;
    private long jGH = 0;
    private long jGJ = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.jGG = 0L;
                a.this.jGH = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.jGI != null) {
                    a.this.jGI.cDz();
                }
                a.this.count = 0;
                a.this.jGG = 0L;
                a.this.jGH = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0682a {
        void cDy();

        void cDz();
    }

    public a(InterfaceC0682a interfaceC0682a) {
        this.jGI = interfaceC0682a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.jGI == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.jGG = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.jGJ);
                return true;
            } else if (this.count == 2) {
                this.jGH = System.currentTimeMillis();
                if (this.jGH - this.jGG < this.jGJ) {
                    this.jGI.cDy();
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
