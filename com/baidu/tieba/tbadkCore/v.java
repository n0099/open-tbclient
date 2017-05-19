package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class v implements View.OnTouchListener {
    private a ftg;
    private int count = 0;
    private long edW = 0;
    private long edX = 0;
    private long edZ = 500;
    private Handler mHandler = new w(this);

    /* loaded from: classes.dex */
    public interface a {
        void ZV();

        void ZW();
    }

    public v(a aVar) {
        this.ftg = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ftg == null) {
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
                    this.ftg.ZW();
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
