package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0074a esw;
    private int count = 0;
    private long esu = 0;
    private long esv = 0;
    private long esx = 500;
    private Handler mHandler = new b(this);

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074a {
        void aeO();

        void aeP();
    }

    public a(InterfaceC0074a interfaceC0074a) {
        this.esw = interfaceC0074a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.esw == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.esu = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.esx);
                return true;
            } else if (this.count == 2) {
                this.esv = System.currentTimeMillis();
                if (this.esv - this.esu < this.esx) {
                    this.esw.aeP();
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
