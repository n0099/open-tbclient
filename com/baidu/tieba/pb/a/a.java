package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0698a kas;
    private int count = 0;
    private long kaq = 0;
    private long kar = 0;
    private long kat = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.kaq = 0L;
                a.this.kar = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.kas != null) {
                    a.this.kas.cHP();
                }
                a.this.count = 0;
                a.this.kaq = 0L;
                a.this.kar = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0698a {
        void cHO();

        void cHP();
    }

    public a(InterfaceC0698a interfaceC0698a) {
        this.kas = interfaceC0698a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.kas == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.kaq = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.kat);
                return true;
            } else if (this.count == 2) {
                this.kar = System.currentTimeMillis();
                if (this.kar - this.kaq < this.kat) {
                    this.kas.cHO();
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
