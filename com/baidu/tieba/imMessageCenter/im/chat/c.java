package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes2.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity dqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.dqT = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dqT.apA();
    }
}
