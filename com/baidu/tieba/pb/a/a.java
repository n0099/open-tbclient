package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0367a hCo;
    private int count = 0;
    private long hCm = 0;
    private long hCn = 0;
    private long hCp = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hCm = 0L;
                a.this.hCn = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hCo != null) {
                    a.this.hCo.bQz();
                }
                a.this.count = 0;
                a.this.hCm = 0L;
                a.this.hCn = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0367a {
        void bQy();

        void bQz();
    }

    public a(InterfaceC0367a interfaceC0367a) {
        this.hCo = interfaceC0367a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hCo == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hCm = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hCp);
                return true;
            } else if (this.count == 2) {
                this.hCn = System.currentTimeMillis();
                if (this.hCn - this.hCm < this.hCp) {
                    this.hCo.bQy();
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
