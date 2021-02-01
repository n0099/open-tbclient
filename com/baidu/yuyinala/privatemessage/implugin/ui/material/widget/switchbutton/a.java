package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class a {
    private static int pfY = 256;
    private static int pfZ = 7;
    private static int pga = 16;
    private int mFrom;
    private b pgc;
    private int pgd;
    private int pge;
    private boolean isAnimating = false;
    private int bJg = pfZ;
    private HandlerC0973a pgb = new HandlerC0973a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        boolean elL();

        void elM();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a elK() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.pgc = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0973a extends Handler {
        private HandlerC0973a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.pfY && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dP(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.pge = i2;
        this.pgd = this.bJg;
        if (this.pge > this.mFrom) {
            this.pgd = Math.abs(this.bJg);
        } else if (this.pge < this.mFrom) {
            this.pgd = -Math.abs(this.bJg);
        } else {
            this.isAnimating = false;
            this.pgc.elM();
            return;
        }
        this.pgc.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void NR(int i) {
        if (i <= 0) {
            this.bJg = pfZ;
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
                elN();
                a.this.pgc.onFrameUpdate(a.this.pgd);
                if (a.this.pgc.elL()) {
                    elO();
                    return;
                }
                a.this.stopAnimation();
                a.this.pgc.elM();
            }
        }

        private void elN() {
        }

        private void elO() {
            Message obtainMessage = a.this.pgb.obtainMessage();
            obtainMessage.what = a.pfY;
            obtainMessage.obj = this;
            a.this.pgb.sendMessageDelayed(obtainMessage, a.pga);
        }
    }
}
