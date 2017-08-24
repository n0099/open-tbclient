package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0108a eGO;
    private int count = 0;
    private long eGM = 0;
    private long eGN = 0;
    private long eGP = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.eGM = 0L;
                a.this.eGN = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.eGO != null) {
                    a.this.eGO.ago();
                }
                a.this.count = 0;
                a.this.eGM = 0L;
                a.this.eGN = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0108a {
        void ago();

        void agp();
    }

    public a(InterfaceC0108a interfaceC0108a) {
        this.eGO = interfaceC0108a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.eGO == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.eGM = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.eGP);
                return true;
            } else if (this.count == 2) {
                this.eGN = System.currentTimeMillis();
                if (this.eGN - this.eGM < this.eGP) {
                    this.eGO.agp();
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
