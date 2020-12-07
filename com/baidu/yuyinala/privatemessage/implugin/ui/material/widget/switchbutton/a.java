package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a {
    private static int oUf = 256;
    private static int oUg = 7;
    private static int oUh = 16;
    private int mFrom;
    private b oUj;
    private int oUk;
    private int oUl;
    private boolean isAnimating = false;
    private int bFu = oUg;
    private HandlerC0972a oUi = new HandlerC0972a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        boolean eni();

        void enj();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a enh() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.oUj = bVar;
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
            if (message.what == a.oUf && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dU(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.oUl = i2;
        this.oUk = this.bFu;
        if (this.oUl > this.mFrom) {
            this.oUk = Math.abs(this.bFu);
        } else if (this.oUl < this.mFrom) {
            this.oUk = -Math.abs(this.bFu);
        } else {
            this.isAnimating = false;
            this.oUj.enj();
            return;
        }
        this.oUj.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void Pp(int i) {
        if (i <= 0) {
            this.bFu = oUg;
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
                enk();
                a.this.oUj.onFrameUpdate(a.this.oUk);
                if (a.this.oUj.eni()) {
                    enl();
                    return;
                }
                a.this.stopAnimation();
                a.this.oUj.enj();
            }
        }

        private void enk() {
        }

        private void enl() {
            Message obtainMessage = a.this.oUi.obtainMessage();
            obtainMessage.what = a.oUf;
            obtainMessage.obj = this;
            a.this.oUi.sendMessageDelayed(obtainMessage, a.oUh);
        }
    }
}
