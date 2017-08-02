package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0108a eDF;
    private int count = 0;
    private long eDD = 0;
    private long eDE = 0;
    private long eDG = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eDD = 0L;
                a.this.eDE = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eDF != null) {
                    a.this.eDF.afS();
                }
                a.this.count = 0;
                a.this.eDD = 0L;
                a.this.eDE = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0108a {
        void afS();

        void afT();
    }

    public a(InterfaceC0108a interfaceC0108a) {
        this.eDF = interfaceC0108a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eDF == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eDD = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eDG);
                return true;
            } else if (this.count == 2) {
                this.eDE = System.currentTimeMillis();
                if (this.eDE - this.eDD < this.eDG) {
                    this.eDF.afT();
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
