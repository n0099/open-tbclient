package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ FloatingPersonalChatView cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FloatingPersonalChatView floatingPersonalChatView) {
        this.cwo = floatingPersonalChatView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajy().fe(false);
        this.cwo.akp();
    }
}
