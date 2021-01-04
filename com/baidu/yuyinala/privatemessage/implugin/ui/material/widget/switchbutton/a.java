package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class a {
    private static int pan = 256;
    private static int pao = 7;
    private static int pap = 16;
    private int mFrom;
    private b par;
    private int pas;
    private int pat;
    private boolean isAnimating = false;
    private int bKi = pao;
    private HandlerC0948a paq = new HandlerC0948a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        boolean enl();

        void enm();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a enk() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.par = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0948a extends Handler {
        private HandlerC0948a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.pan && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dS(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.pat = i2;
        this.pas = this.bKi;
        if (this.pat > this.mFrom) {
            this.pas = Math.abs(this.bKi);
        } else if (this.pat < this.mFrom) {
            this.pas = -Math.abs(this.bKi);
        } else {
            this.isAnimating = false;
            this.par.enm();
            return;
        }
        this.par.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void Pd(int i) {
        if (i <= 0) {
            this.bKi = pao;
        } else {
            this.bKi = i;
        }
    }

    /* loaded from: classes11.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAnimating) {
                enn();
                a.this.par.onFrameUpdate(a.this.pas);
                if (a.this.par.enl()) {
                    eno();
                    return;
                }
                a.this.stopAnimation();
                a.this.par.enm();
            }
        }

        private void enn() {
        }

        private void eno() {
            Message obtainMessage = a.this.paq.obtainMessage();
            obtainMessage.what = a.pan;
            obtainMessage.obj = this;
            a.this.paq.sendMessageDelayed(obtainMessage, a.pap);
        }
    }
}
