package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a {
    private static int oEZ = 256;
    private static int oFa = 7;
    private static int oFb = 16;
    private int mFrom;
    private b oFd;
    private int oFe;
    private int oFf;
    private boolean isAnimating = false;
    private int bAm = oFa;
    private HandlerC0955a oFc = new HandlerC0955a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        boolean eht();

        void ehu();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a ehs() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.oFd = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0955a extends Handler {
        private HandlerC0955a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.oEZ && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dP(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.oFf = i2;
        this.oFe = this.bAm;
        if (this.oFf > this.mFrom) {
            this.oFe = Math.abs(this.bAm);
        } else if (this.oFf < this.mFrom) {
            this.oFe = -Math.abs(this.bAm);
        } else {
            this.isAnimating = false;
            this.oFd.ehu();
            return;
        }
        this.oFd.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void Or(int i) {
        if (i <= 0) {
            this.bAm = oFa;
        } else {
            this.bAm = i;
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAnimating) {
                ehv();
                a.this.oFd.onFrameUpdate(a.this.oFe);
                if (a.this.oFd.eht()) {
                    ehw();
                    return;
                }
                a.this.stopAnimation();
                a.this.oFd.ehu();
            }
        }

        private void ehv() {
        }

        private void ehw() {
            Message obtainMessage = a.this.oFc.obtainMessage();
            obtainMessage.what = a.oEZ;
            obtainMessage.obj = this;
            a.this.oFc.sendMessageDelayed(obtainMessage, a.oFb);
        }
    }
}
