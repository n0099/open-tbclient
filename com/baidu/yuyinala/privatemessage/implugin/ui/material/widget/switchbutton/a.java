package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a {
    private static int ouc = 256;
    private static int oud = 7;
    private static int oue = 16;
    private int mFrom;
    private b oug;
    private int ouh;
    private int oui;
    private boolean isAnimating = false;
    private int bvM = oud;
    private HandlerC0934a ouf = new HandlerC0934a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        boolean edG();

        void edH();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a edF() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.oug = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0934a extends Handler {
        private HandlerC0934a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.ouc && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dL(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.oui = i2;
        this.ouh = this.bvM;
        if (this.oui > this.mFrom) {
            this.ouh = Math.abs(this.bvM);
        } else if (this.oui < this.mFrom) {
            this.ouh = -Math.abs(this.bvM);
        } else {
            this.isAnimating = false;
            this.oug.edH();
            return;
        }
        this.oug.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void Nt(int i) {
        if (i <= 0) {
            this.bvM = oud;
        } else {
            this.bvM = i;
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAnimating) {
                edI();
                a.this.oug.onFrameUpdate(a.this.ouh);
                if (a.this.oug.edG()) {
                    edJ();
                    return;
                }
                a.this.stopAnimation();
                a.this.oug.edH();
            }
        }

        private void edI() {
        }

        private void edJ() {
            Message obtainMessage = a.this.ouf.obtainMessage();
            obtainMessage.what = a.ouc;
            obtainMessage.obj = this;
            a.this.ouf.sendMessageDelayed(obtainMessage, a.oue);
        }
    }
}
