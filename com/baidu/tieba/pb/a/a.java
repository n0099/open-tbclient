package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0067a eiy;
    private int count = 0;
    private long eiw = 0;
    private long eix = 0;
    private long eiz = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void ZU();

        void ZV();
    }

    public a(InterfaceC0067a interfaceC0067a) {
        this.eiy = interfaceC0067a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eiy == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eiw = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eiz);
                return true;
            } else if (this.count == 2) {
                this.eix = System.currentTimeMillis();
                if (this.eix - this.eiw < this.eiz) {
                    this.eiy.ZV();
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
