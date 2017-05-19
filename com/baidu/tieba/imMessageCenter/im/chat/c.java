package com.baidu.tieba.imMessageCenter.im.chat;
/* loaded from: classes2.dex */
class c implements Runnable {
    final /* synthetic */ PersonalChatActivity ddC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalChatActivity personalChatActivity) {
        this.ddC = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ddC.akP();
    }
}
