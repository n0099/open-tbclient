package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dbp = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dbp.akb();
    }
}
