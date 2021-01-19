package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class a {
    private static int oVL = 256;
    private static int oVM = 7;
    private static int oVN = 16;
    private int mFrom;
    private b oVP;
    private int oVQ;
    private int oVR;
    private boolean isAnimating = false;
    private int bFw = oVM;
    private HandlerC0969a oVO = new HandlerC0969a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface b {
        boolean ejr();

        void ejs();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a ejq() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.oVP = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0969a extends Handler {
        private HandlerC0969a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.oVL && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dS(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.oVR = i2;
        this.oVQ = this.bFw;
        if (this.oVR > this.mFrom) {
            this.oVQ = Math.abs(this.bFw);
        } else if (this.oVR < this.mFrom) {
            this.oVQ = -Math.abs(this.bFw);
        } else {
            this.isAnimating = false;
            this.oVP.ejs();
            return;
        }
        this.oVP.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void Nw(int i) {
        if (i <= 0) {
            this.bFw = oVM;
        } else {
            this.bFw = i;
        }
    }

    /* loaded from: classes10.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAnimating) {
                ejt();
                a.this.oVP.onFrameUpdate(a.this.oVQ);
                if (a.this.oVP.ejr()) {
                    eju();
                    return;
                }
                a.this.stopAnimation();
                a.this.oVP.ejs();
            }
        }

        private void ejt() {
        }

        private void eju() {
            Message obtainMessage = a.this.oVO.obtainMessage();
            obtainMessage.what = a.oVL;
            obtainMessage.obj = this;
            a.this.oVO.sendMessageDelayed(obtainMessage, a.oVN);
        }
    }
}
