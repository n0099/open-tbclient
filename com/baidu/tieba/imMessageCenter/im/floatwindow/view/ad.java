package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ FloatingPersonalChatView cgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FloatingPersonalChatView floatingPersonalChatView) {
        this.cgl = floatingPersonalChatView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().dZ(false);
        this.cgl.adE();
    }
}
