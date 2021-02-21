package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class a {
    private int mFrom;
    private b pgC;
    private int pgD;
    private int pgE;
    private static int pgy = 256;
    private static int pgz = 7;
    private static int pgA = 16;
    private boolean isAnimating = false;
    private int bJg = pgz;
    private HandlerC0975a pgB = new HandlerC0975a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        boolean elT();

        void elU();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a elS() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.pgC = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0975a extends Handler {
        private HandlerC0975a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.pgy && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dQ(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.pgE = i2;
        this.pgD = this.bJg;
        if (this.pgE > this.mFrom) {
            this.pgD = Math.abs(this.bJg);
        } else if (this.pgE < this.mFrom) {
            this.pgD = -Math.abs(this.bJg);
        } else {
            this.isAnimating = false;
            this.pgC.elU();
            return;
        }
        this.pgC.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void NS(int i) {
        if (i <= 0) {
            this.bJg = pgz;
        } else {
            this.bJg = i;
        }
    }

    /* loaded from: classes11.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAnimating) {
                elV();
                a.this.pgC.onFrameUpdate(a.this.pgD);
                if (a.this.pgC.elT()) {
                    elW();
                    return;
                }
                a.this.stopAnimation();
                a.this.pgC.elU();
            }
        }

        private void elV() {
        }

        private void elW() {
            Message obtainMessage = a.this.pgB.obtainMessage();
            obtainMessage.what = a.pgy;
            obtainMessage.obj = this;
            a.this.pgB.sendMessageDelayed(obtainMessage, a.pgA);
        }
    }
}
