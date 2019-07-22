package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0366a hIF;
    private int count = 0;
    private long hID = 0;
    private long hIE = 0;
    private long hIG = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hID = 0L;
                a.this.hIE = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hIF != null) {
                    a.this.hIF.bTo();
                }
                a.this.count = 0;
                a.this.hID = 0L;
                a.this.hIE = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0366a {
        void bTn();

        void bTo();
    }

    public a(InterfaceC0366a interfaceC0366a) {
        this.hIF = interfaceC0366a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hIF == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hID = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hIG);
                return true;
            } else if (this.count == 2) {
                this.hIE = System.currentTimeMillis();
                if (this.hIE - this.hID < this.hIG) {
                    this.hIF.bTn();
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
