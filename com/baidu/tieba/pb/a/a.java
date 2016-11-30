package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0072a esI;
    private int count = 0;
    private long esG = 0;
    private long esH = 0;
    private long esJ = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
        void adv();

        void adw();
    }

    public a(InterfaceC0072a interfaceC0072a) {
        this.esI = interfaceC0072a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.esI == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.esG = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.esJ);
                return true;
            } else if (this.count == 2) {
                this.esH = System.currentTimeMillis();
                if (this.esH - this.esG < this.esJ) {
                    this.esI.adw();
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
