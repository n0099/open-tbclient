package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity bKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.bKb = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bKb.RJ();
    }
}
