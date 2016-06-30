package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0071a dMv;
    private int count = 0;
    private long dMt = 0;
    private long dMu = 0;
    private long dMw = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0071a {
        void WO();

        void WP();
    }

    public a(InterfaceC0071a interfaceC0071a) {
        this.dMv = interfaceC0071a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.dMv == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.dMt = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.dMw);
                return true;
            } else if (this.count == 2) {
                this.dMu = System.currentTimeMillis();
                if (this.dMu - this.dMt < this.dMw) {
                    this.dMv.WP();
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
