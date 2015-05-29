package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity brU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.brU = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.brU.OW();
    }
}
