package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0761a kyz;
    private int count = 0;
    private long kyx = 0;
    private long kyy = 0;
    private long kyA = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.kyx = 0L;
                a.this.kyy = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.kyz != null) {
                    a.this.kyz.cWp();
                }
                a.this.count = 0;
                a.this.kyx = 0L;
                a.this.kyy = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0761a {
        void cWo();

        void cWp();
    }

    public a(InterfaceC0761a interfaceC0761a) {
        this.kyz = interfaceC0761a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.kyz == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.kyx = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.kyA);
                return true;
            } else if (this.count == 2) {
                this.kyy = System.currentTimeMillis();
                if (this.kyy - this.kyx < this.kyA) {
                    this.kyz.cWo();
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
