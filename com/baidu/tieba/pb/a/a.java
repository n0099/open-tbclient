package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0761a kys;
    private int count = 0;
    private long kyq = 0;
    private long kyr = 0;
    private long kyt = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.kyq = 0L;
                a.this.kyr = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.kys != null) {
                    a.this.kys.cWo();
                }
                a.this.count = 0;
                a.this.kyq = 0L;
                a.this.kyr = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0761a {
        void cWn();

        void cWo();
    }

    public a(InterfaceC0761a interfaceC0761a) {
        this.kys = interfaceC0761a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.kys == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.kyq = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.kyt);
                return true;
            } else if (this.count == 2) {
                this.kyr = System.currentTimeMillis();
                if (this.kyr - this.kyq < this.kyt) {
                    this.kys.cWn();
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
