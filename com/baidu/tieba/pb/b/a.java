package com.baidu.tieba.pb.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0078a czG;
    private int count = 0;
    private long czE = 0;
    private long czF = 0;
    private long czH = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0078a {
        void NW();

        void NX();
    }

    public a(InterfaceC0078a interfaceC0078a) {
        this.czG = interfaceC0078a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.czG == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.czE = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.czH);
                return true;
            } else if (this.count == 2) {
                this.czF = System.currentTimeMillis();
                if (this.czF - this.czE < this.czH) {
                    this.czG.NX();
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
