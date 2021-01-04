package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0807a lHC;
    private int count = 0;
    private long lHA = 0;
    private long lHB = 0;
    private long lHD = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.lHA = 0L;
                a.this.lHB = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.lHC != null) {
                    a.this.lHC.dnI();
                }
                a.this.count = 0;
                a.this.lHA = 0L;
                a.this.lHB = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0807a {
        void dnH();

        void dnI();
    }

    public a(InterfaceC0807a interfaceC0807a) {
        this.lHC = interfaceC0807a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.lHC == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.lHA = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.lHD);
                return true;
            } else if (this.count == 2) {
                this.lHB = System.currentTimeMillis();
                if (this.lHB - this.lHA < this.lHD) {
                    this.lHC.dnH();
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
