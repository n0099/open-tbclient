package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0833a lOc;
    private int count = 0;
    private long lOa = 0;
    private long lOb = 0;
    private long lOd = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.lOa = 0L;
                a.this.lOb = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.lOc != null) {
                    a.this.lOc.dmt();
                }
                a.this.count = 0;
                a.this.lOa = 0L;
                a.this.lOb = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0833a {
        void dms();

        void dmt();
    }

    public a(InterfaceC0833a interfaceC0833a) {
        this.lOc = interfaceC0833a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.lOc == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.lOa = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.lOd);
                return true;
            } else if (this.count == 2) {
                this.lOb = System.currentTimeMillis();
                if (this.lOb - this.lOa < this.lOd) {
                    this.lOc.dms();
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
