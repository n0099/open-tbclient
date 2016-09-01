package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity dpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dpU = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dpU.apA();
    }
}
