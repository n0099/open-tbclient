package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0569a iEJ;
    private int count = 0;
    private long iEH = 0;
    private long iEI = 0;
    private long iEK = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.iEH = 0L;
                a.this.iEI = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.iEJ != null) {
                    a.this.iEJ.clI();
                }
                a.this.count = 0;
                a.this.iEH = 0L;
                a.this.iEI = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0569a {
        void clH();

        void clI();
    }

    public a(InterfaceC0569a interfaceC0569a) {
        this.iEJ = interfaceC0569a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.iEJ == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.iEH = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.iEK);
                return true;
            } else if (this.count == 2) {
                this.iEI = System.currentTimeMillis();
                if (this.iEI - this.iEH < this.iEK) {
                    this.iEJ.clH();
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
