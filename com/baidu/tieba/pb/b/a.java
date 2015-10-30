package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0070a cgE;
    private int count = 0;
    private long cgC = 0;
    private long cgD = 0;
    private long cgF = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void Me();

        void Mf();
    }

    public a(InterfaceC0070a interfaceC0070a) {
        this.cgE = interfaceC0070a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.cgE == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.cgC = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.cgF);
                return true;
            } else if (this.count == 2) {
                this.cgD = System.currentTimeMillis();
                if (this.cgD - this.cgC < this.cgF) {
                    this.cgE.Mf();
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
