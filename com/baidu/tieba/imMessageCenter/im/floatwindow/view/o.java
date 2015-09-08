package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bJh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bJh = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bJh.QK();
    }
}
