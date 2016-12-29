package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity cZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.cZd = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cZd.amy();
    }
}
