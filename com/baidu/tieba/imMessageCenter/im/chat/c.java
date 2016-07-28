package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity dbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.dbu = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dbu.akL();
    }
}
