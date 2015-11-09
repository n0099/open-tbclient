package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ FloatingPersonalChatView bNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FloatingPersonalChatView floatingPersonalChatView) {
        this.bNh = floatingPersonalChatView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yy().dE(false);
        this.bNh.Zp();
    }
}
