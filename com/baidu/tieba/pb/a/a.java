package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0477a hJk;
    private int count = 0;
    private long hJi = 0;
    private long hJj = 0;
    private long hJl = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hJi = 0L;
                a.this.hJj = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hJk != null) {
                    a.this.hJk.bRo();
                }
                a.this.count = 0;
                a.this.hJi = 0L;
                a.this.hJj = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0477a {
        void bRn();

        void bRo();
    }

    public a(InterfaceC0477a interfaceC0477a) {
        this.hJk = interfaceC0477a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hJk == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hJi = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hJl);
                return true;
            } else if (this.count == 2) {
                this.hJj = System.currentTimeMillis();
                if (this.hJj - this.hJi < this.hJl) {
                    this.hJk.bRn();
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
