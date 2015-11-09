package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMS = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bMS.RJ();
    }
}
