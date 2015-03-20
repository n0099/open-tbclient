package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity brH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.brH = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.brH.Nu();
    }
}
