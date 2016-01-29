package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity ckw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.ckw = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ckw.Yu();
    }
}
