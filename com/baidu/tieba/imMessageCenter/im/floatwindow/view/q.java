package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.buJ = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.buJ.OW();
    }
}
