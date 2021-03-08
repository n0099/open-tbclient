package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class a {
    private static int piG = 256;
    private static int piH = 7;
    private static int piI = 16;
    private int mFrom;
    private b piK;
    private int piL;
    private int piM;
    private boolean isAnimating = false;
    private int bKG = piH;
    private HandlerC0981a piJ = new HandlerC0981a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface b {
        boolean emd();

        void eme();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a emc() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.piK = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0981a extends Handler {
        private HandlerC0981a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.piG && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dQ(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.piM = i2;
        this.piL = this.bKG;
        if (this.piM > this.mFrom) {
            this.piL = Math.abs(this.bKG);
        } else if (this.piM < this.mFrom) {
            this.piL = -Math.abs(this.bKG);
        } else {
            this.isAnimating = false;
            this.piK.eme();
            return;
        }
        this.piK.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void NW(int i) {
        if (i <= 0) {
            this.bKG = piH;
        } else {
            this.bKG = i;
        }
    }

    /* loaded from: classes10.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAnimating) {
                emf();
                a.this.piK.onFrameUpdate(a.this.piL);
                if (a.this.piK.emd()) {
                    emg();
                    return;
                }
                a.this.stopAnimation();
                a.this.piK.eme();
            }
        }

        private void emf() {
        }

        private void emg() {
            Message obtainMessage = a.this.piJ.obtainMessage();
            obtainMessage.what = a.piG;
            obtainMessage.obj = this;
            a.this.piJ.sendMessageDelayed(obtainMessage, a.piI);
        }
    }
}
