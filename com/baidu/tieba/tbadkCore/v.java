package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class v implements View.OnTouchListener {
    private a fLb;
    private int count = 0;
    private long esu = 0;
    private long esv = 0;
    private long esx = 500;
    private Handler mHandler = new w(this);

    /* loaded from: classes.dex */
    public interface a {
        void aeO();

        void aeP();
    }

    public v(a aVar) {
        this.fLb = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fLb == null) {
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
                    this.fLb.aeP();
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
