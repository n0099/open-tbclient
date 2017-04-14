package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0066a egF;
    private int count = 0;
    private long egD = 0;
    private long egE = 0;
    private long egG = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0066a {
        void aas();

        void aat();
    }

    public a(InterfaceC0066a interfaceC0066a) {
        this.egF = interfaceC0066a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.egF == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.egD = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.egG);
                return true;
            } else if (this.count == 2) {
                this.egE = System.currentTimeMillis();
                if (this.egE - this.egD < this.egG) {
                    this.egF.aat();
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
