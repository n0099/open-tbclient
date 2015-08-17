package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0065a cat;
    private int count = 0;
    private long car = 0;
    private long cas = 0;
    private long cau = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
        void Ms();

        void Mt();
    }

    public a(InterfaceC0065a interfaceC0065a) {
        this.cat = interfaceC0065a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cat == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.car = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cau);
                return true;
            } else if (this.count == 2) {
                this.cas = System.currentTimeMillis();
                if (this.cas - this.car < this.cau) {
                    this.cat.Mt();
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
