package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0109a eHH;
    private int count = 0;
    private long eHF = 0;
    private long eHG = 0;
    private long eHI = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eHF = 0L;
                a.this.eHG = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eHH != null) {
                    a.this.eHH.akk();
                }
                a.this.count = 0;
                a.this.eHF = 0L;
                a.this.eHG = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109a {
        void akk();

        void akl();
    }

    public a(InterfaceC0109a interfaceC0109a) {
        this.eHH = interfaceC0109a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eHH == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eHF = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eHI);
                return true;
            } else if (this.count == 2) {
                this.eHG = System.currentTimeMillis();
                if (this.eHG - this.eHF < this.eHI) {
                    this.eHH.akl();
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
