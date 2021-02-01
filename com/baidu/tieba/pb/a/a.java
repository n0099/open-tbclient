package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0826a lLL;
    private int count = 0;
    private long lLJ = 0;
    private long lLK = 0;
    private long lLM = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.lLJ = 0L;
                a.this.lLK = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.lLL != null) {
                    a.this.lLL.dmd();
                }
                a.this.count = 0;
                a.this.lLJ = 0L;
                a.this.lLK = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0826a {
        void dmc();

        void dmd();
    }

    public a(InterfaceC0826a interfaceC0826a) {
        this.lLL = interfaceC0826a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.lLL == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.lLJ = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.lLM);
                return true;
            } else if (this.count == 2) {
                this.lLK = System.currentTimeMillis();
                if (this.lLK - this.lLJ < this.lLM) {
                    this.lLL.dmc();
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
