package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a {
    private static int oDv = 256;
    private static int oDw = 7;
    private static int oDx = 16;
    private int mFrom;
    private int oDA;
    private int oDB;
    private b oDz;
    private boolean isAnimating = false;
    private int bBX = oDw;
    private HandlerC0952a oDy = new HandlerC0952a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        boolean ehv();

        void ehw();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a ehu() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(b bVar) {
        if (bVar == null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("SwitchButtonAnimationController", "onAnimateListener can not be null");
        } else {
            this.oDz = bVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0952a extends Handler {
        private HandlerC0952a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == a.oDv && message.obj != null) {
                ((Runnable) message.obj).run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dO(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.oDB = i2;
        this.oDA = this.bBX;
        if (this.oDB > this.mFrom) {
            this.oDA = Math.abs(this.bBX);
        } else if (this.oDB < this.mFrom) {
            this.oDA = -Math.abs(this.bBX);
        } else {
            this.isAnimating = false;
            this.oDz.ehw();
            return;
        }
        this.oDz.onAnimationStart();
        new c().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void NO(int i) {
        if (i <= 0) {
            this.bBX = oDw;
        } else {
            this.bBX = i;
        }
    }

    /* loaded from: classes4.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isAnimating) {
                ehx();
                a.this.oDz.onFrameUpdate(a.this.oDA);
                if (a.this.oDz.ehv()) {
                    ehy();
                    return;
                }
                a.this.stopAnimation();
                a.this.oDz.ehw();
            }
        }

        private void ehx() {
        }

        private void ehy() {
            Message obtainMessage = a.this.oDy.obtainMessage();
            obtainMessage.what = a.oDv;
            obtainMessage.obj = this;
            a.this.oDy.sendMessageDelayed(obtainMessage, a.oDx);
        }
    }
}
