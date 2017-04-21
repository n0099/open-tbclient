package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0066a eiV;
    private int count = 0;
    private long eiT = 0;
    private long eiU = 0;
    private long eiW = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0066a {
        void abt();

        void abu();
    }

    public a(InterfaceC0066a interfaceC0066a) {
        this.eiV = interfaceC0066a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eiV == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eiT = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eiW);
                return true;
            } else if (this.count == 2) {
                this.eiU = System.currentTimeMillis();
                if (this.eiU - this.eiT < this.eiW) {
                    this.eiV.abu();
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
