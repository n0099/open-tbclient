package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0556a ixx;
    private int count = 0;
    private long ixv = 0;
    private long ixw = 0;
    private long ixy = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.ixv = 0L;
                a.this.ixw = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.ixx != null) {
                    a.this.ixx.ciE();
                }
                a.this.count = 0;
                a.this.ixv = 0L;
                a.this.ixw = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0556a {
        void ciD();

        void ciE();
    }

    public a(InterfaceC0556a interfaceC0556a) {
        this.ixx = interfaceC0556a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.ixx == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.ixv = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.ixy);
                return true;
            } else if (this.count == 2) {
                this.ixw = System.currentTimeMillis();
                if (this.ixw - this.ixv < this.ixy) {
                    this.ixx.ciD();
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
