package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity cbW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.cbW = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cbW.UP();
    }
}
