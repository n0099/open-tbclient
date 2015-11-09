package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ PersonalChatActivity bKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalChatActivity personalChatActivity) {
        this.bKb = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.bKb.mListView;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.bKb.mListView;
            absMsglistView.showNotNotfiy();
        }
    }
}
