package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a {
    private static int oUh = 256;
    private static int oUi = 7;
    private static int oUj = 16;
    private int mFrom;
    private b oUl;
    private int oUm;
    private int oUn;
    private boolean isAnimating = false;
    private int bFu = oUi;
    private HandlerC0972a oUk = new HandlerC0972a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        boolean enj();

        void enk();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a eni() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.oUl = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0972a extends Handler {
        private HandlerC0972a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.oUh && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dU(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.oUn = i2;
        this.oUm = this.bFu;
        if (this.oUn > this.mFrom) {
            this.oUm = Math.abs(this.bFu);
        } else if (this.oUn < this.mFrom) {
            this.oUm = -Math.abs(this.bFu);
        } else {
            this.isAnimating = false;
            this.oUl.enk();
            return;
        }
        this.oUl.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void Pp(int i) {
        if (i <= 0) {
            this.bFu = oUi;
        } else {
            this.bFu = i;
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAnimating) {
                enl();
                a.this.oUl.onFrameUpdate(a.this.oUm);
                if (a.this.oUl.enj()) {
                    enm();
                    return;
                }
                a.this.stopAnimation();
                a.this.oUl.enk();
            }
        }

        private void enl() {
        }

        private void enm() {
            Message obtainMessage = a.this.oUk.obtainMessage();
            obtainMessage.what = a.oUh;
            obtainMessage.obj = this;
            a.this.oUk.sendMessageDelayed(obtainMessage, a.oUj);
        }
    }
}
