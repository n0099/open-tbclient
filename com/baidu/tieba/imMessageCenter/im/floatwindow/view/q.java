package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity brX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.brX = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.brX.NH();
    }
}
