package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0071a ejy;
    private int count = 0;
    private long ejw = 0;
    private long ejx = 0;
    private long ejz = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0071a {
        void aaX();

        void aaY();
    }

    public a(InterfaceC0071a interfaceC0071a) {
        this.ejy = interfaceC0071a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ejy == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ejw = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ejz);
                return true;
            } else if (this.count == 2) {
                this.ejx = System.currentTimeMillis();
                if (this.ejx - this.ejw < this.ejz) {
                    this.ejy.aaY();
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
