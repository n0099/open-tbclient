package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0710a kiY;
    private int count = 0;
    private long kiW = 0;
    private long kiX = 0;
    private long kiZ = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.kiW = 0L;
                a.this.kiX = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.kiY != null) {
                    a.this.kiY.cLA();
                }
                a.this.count = 0;
                a.this.kiW = 0L;
                a.this.kiX = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0710a {
        void cLA();

        void cLz();
    }

    public a(InterfaceC0710a interfaceC0710a) {
        this.kiY = interfaceC0710a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.kiY == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.kiW = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.kiZ);
                return true;
            } else if (this.count == 2) {
                this.kiX = System.currentTimeMillis();
                if (this.kiX - this.kiW < this.kiZ) {
                    this.kiY.cLz();
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
