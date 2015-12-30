package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity cdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.cdg = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdg.VV();
    }
}
