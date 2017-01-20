package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0068a egc;
    private int count = 0;
    private long ega = 0;
    private long egb = 0;
    private long egd = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0068a {
        void YV();

        void YW();
    }

    public a(InterfaceC0068a interfaceC0068a) {
        this.egc = interfaceC0068a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.egc == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ega = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.egd);
                return true;
            } else if (this.count == 2) {
                this.egb = System.currentTimeMillis();
                if (this.egb - this.ega < this.egd) {
                    this.egc.YW();
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
