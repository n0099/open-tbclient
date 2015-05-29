package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ FloatingPersonalChatView buY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.buY = floatingPersonalChatView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.VP().du(false);
        this.buY.WH();
    }
}
