package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0070a ekJ;
    private int count = 0;
    private long ekH = 0;
    private long ekI = 0;
    private long ekK = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void acd();

        void ace();
    }

    public a(InterfaceC0070a interfaceC0070a) {
        this.ekJ = interfaceC0070a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ekJ == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ekH = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ekK);
                return true;
            } else if (this.count == 2) {
                this.ekI = System.currentTimeMillis();
                if (this.ekI - this.ekH < this.ekK) {
                    this.ekJ.ace();
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
