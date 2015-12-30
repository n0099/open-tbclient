package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0073a cDl;
    private int count = 0;
    private long cDj = 0;
    private long cDk = 0;
    private long cDm = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073a {
        void Op();

        void Oq();
    }

    public a(InterfaceC0073a interfaceC0073a) {
        this.cDl = interfaceC0073a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cDl == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cDj = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cDm);
                return true;
            } else if (this.count == 2) {
                this.cDk = System.currentTimeMillis();
                if (this.cDk - this.cDj < this.cDm) {
                    this.cDl.Oq();
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
