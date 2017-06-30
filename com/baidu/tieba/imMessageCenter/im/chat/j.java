package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes2.dex */
class j implements com.baidu.tbadk.util.h<Boolean> {
    final /* synthetic */ PersonalChatActivity dqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalChatActivity personalChatActivity) {
        this.dqT = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.dqT.cYg;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.dqT.cYg;
            absMsglistView.showNotNotfiy();
        }
    }
}
