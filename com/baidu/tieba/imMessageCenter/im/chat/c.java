package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity bGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.bGq = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bGq.QK();
    }
}
