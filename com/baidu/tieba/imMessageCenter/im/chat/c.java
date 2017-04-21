package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity djA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.djA = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.djA.anW();
    }
}
