package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0066a dXg;
    private int count = 0;
    private long dXe = 0;
    private long dXf = 0;
    private long dXh = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0066a {
        void XO();

        void XP();
    }

    public a(InterfaceC0066a interfaceC0066a) {
        this.dXg = interfaceC0066a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.dXg == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.dXe = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.dXh);
                return true;
            } else if (this.count == 2) {
                this.dXf = System.currentTimeMillis();
                if (this.dXf - this.dXe < this.dXh) {
                    this.dXg.XP();
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
