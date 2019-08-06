package com.baidu.tieba.pb.a;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private InterfaceC0372a hJy;
    private int count = 0;
    private long hJw = 0;
    private long hJx = 0;
    private long hJz = 500;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.pb.a.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                a.this.count = 0;
                a.this.hJw = 0L;
                a.this.hJx = 0L;
            } else if (message.what == 1 && a.this.count == 1) {
                if (a.this.hJy != null) {
                    a.this.hJy.bTC();
                }
                a.this.count = 0;
                a.this.hJw = 0L;
                a.this.hJx = 0L;
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0372a {
        void bTB();

        void bTC();
    }

    public a(InterfaceC0372a interfaceC0372a) {
        this.hJy = interfaceC0372a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.hJy == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.hJw = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.hJz);
                return true;
            } else if (this.count == 2) {
                this.hJx = System.currentTimeMillis();
                if (this.hJx - this.hJw < this.hJz) {
                    this.hJy.bTB();
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
