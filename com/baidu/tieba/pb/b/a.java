package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0075a cJR;
    private int count = 0;
    private long cJP = 0;
    private long cJQ = 0;
    private long cJS = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0075a {
        void Qs();

        void Qt();
    }

    public a(InterfaceC0075a interfaceC0075a) {
        this.cJR = interfaceC0075a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cJR == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cJP = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cJS);
                return true;
            } else if (this.count == 2) {
                this.cJQ = System.currentTimeMillis();
                if (this.cJQ - this.cJP < this.cJS) {
                    this.cJR.Qt();
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
