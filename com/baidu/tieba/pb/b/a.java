package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0070a chj;
    private int count = 0;
    private long chh = 0;
    private long chi = 0;
    private long chk = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void Mu();

        void Mv();
    }

    public a(InterfaceC0070a interfaceC0070a) {
        this.chj = interfaceC0070a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.chj == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.chh = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.chk);
                return true;
            } else if (this.count == 2) {
                this.chi = System.currentTimeMillis();
                if (this.chi - this.chh < this.chk) {
                    this.chj.Mv();
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
