package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0071a dYF;
    private int count = 0;
    private long dYD = 0;
    private long dYE = 0;
    private long dYG = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0071a {
        void Xg();

        void Xh();
    }

    public a(InterfaceC0071a interfaceC0071a) {
        this.dYF = interfaceC0071a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.dYF == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.dYD = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.dYG);
                return true;
            } else if (this.count == 2) {
                this.dYE = System.currentTimeMillis();
                if (this.dYE - this.dYD < this.dYG) {
                    this.dYF.Xh();
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
