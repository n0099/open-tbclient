package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0067a cbo;
    private int count = 0;
    private long cbm = 0;
    private long cbn = 0;
    private long cbp = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void Mj();

        void Mk();
    }

    public a(InterfaceC0067a interfaceC0067a) {
        this.cbo = interfaceC0067a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cbo == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cbm = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cbp);
                return true;
            } else if (this.count == 2) {
                this.cbn = System.currentTimeMillis();
                if (this.cbn - this.cbm < this.cbp) {
                    this.cbo.Mk();
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
