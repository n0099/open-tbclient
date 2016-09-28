package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0073a emL;
    private int count = 0;
    private long emJ = 0;
    private long emK = 0;
    private long emM = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073a {
        void acq();

        void acr();
    }

    public a(InterfaceC0073a interfaceC0073a) {
        this.emL = interfaceC0073a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.emL == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.emJ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.emM);
                return true;
            } else if (this.count == 2) {
                this.emK = System.currentTimeMillis();
                if (this.emK - this.emJ < this.emM) {
                    this.emL.acr();
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
