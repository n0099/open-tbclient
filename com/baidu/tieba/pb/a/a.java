package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0071a edY;
    private int count = 0;
    private long edW = 0;
    private long edX = 0;
    private long edZ = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0071a {
        void ZV();

        void ZW();
    }

    public a(InterfaceC0071a interfaceC0071a) {
        this.edY = interfaceC0071a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.edY == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.edW = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.edZ);
                return true;
            } else if (this.count == 2) {
                this.edX = System.currentTimeMillis();
                if (this.edX - this.edW < this.edZ) {
                    this.edY.ZW();
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
