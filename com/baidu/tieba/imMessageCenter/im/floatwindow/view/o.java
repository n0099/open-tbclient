package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMx = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bMx.Rr();
    }
}
