package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0067a dfC;
    private int count = 0;
    private long dfA = 0;
    private long dfB = 0;
    private long dfD = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void Rr();

        void Rs();
    }

    public a(InterfaceC0067a interfaceC0067a) {
        this.dfC = interfaceC0067a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.dfC == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.dfA = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.dfD);
                return true;
            } else if (this.count == 2) {
                this.dfB = System.currentTimeMillis();
                if (this.dfB - this.dfA < this.dfD) {
                    this.dfC.Rs();
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
