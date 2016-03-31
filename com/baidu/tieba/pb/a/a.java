package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0074a ddi;
    private int count = 0;
    private long ddg = 0;
    private long ddh = 0;
    private long ddj = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074a {
        void Sl();

        void Sm();
    }

    public a(InterfaceC0074a interfaceC0074a) {
        this.ddi = interfaceC0074a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ddi == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ddg = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ddj);
                return true;
            } else if (this.count == 2) {
                this.ddh = System.currentTimeMillis();
                if (this.ddh - this.ddg < this.ddj) {
                    this.ddi.Sm();
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
