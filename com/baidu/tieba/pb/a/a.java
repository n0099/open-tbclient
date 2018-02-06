package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0204a fIt;
    private int count = 0;
    private long fIr = 0;
    private long fIs = 0;
    private long fIu = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.fIr = 0L;
                a.this.fIs = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.fIt != null) {
                    a.this.fIt.bbn();
                }
                a.this.count = 0;
                a.this.fIr = 0L;
                a.this.fIs = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0204a {
        void bbm();

        void bbn();
    }

    public a(InterfaceC0204a interfaceC0204a) {
        this.fIt = interfaceC0204a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.fIt == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.fIr = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.fIu);
                return true;
            } else if (this.count == 2) {
                this.fIs = System.currentTimeMillis();
                if (this.fIs - this.fIr < this.fIu) {
                    this.fIt.bbm();
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
