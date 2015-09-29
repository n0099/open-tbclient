package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0070a cgt;
    private int count = 0;
    private long cgr = 0;
    private long cgs = 0;
    private long cgu = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void Mi();

        void Mj();
    }

    public a(InterfaceC0070a interfaceC0070a) {
        this.cgt = interfaceC0070a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cgt == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cgr = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cgu);
                return true;
            } else if (this.count == 2) {
                this.cgs = System.currentTimeMillis();
                if (this.cgs - this.cgr < this.cgu) {
                    this.cgt.Mj();
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
