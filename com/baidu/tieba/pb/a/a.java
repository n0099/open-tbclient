package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0824a lCu;
    private int count = 0;
    private long lCs = 0;
    private long lCt = 0;
    private long lCv = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.lCs = 0L;
                a.this.lCt = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.lCu != null) {
                    a.this.lCu.dnX();
                }
                a.this.count = 0;
                a.this.lCs = 0L;
                a.this.lCt = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0824a {
        void dnW();

        void dnX();
    }

    public a(InterfaceC0824a interfaceC0824a) {
        this.lCu = interfaceC0824a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.lCu == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.lCs = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.lCv);
                return true;
            } else if (this.count == 2) {
                this.lCt = System.currentTimeMillis();
                if (this.lCt - this.lCs < this.lCv) {
                    this.lCu.dnW();
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
