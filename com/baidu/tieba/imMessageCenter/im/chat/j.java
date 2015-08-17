package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ PersonalChatActivity bFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalChatActivity personalChatActivity) {
        this.bFJ = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.bFJ.mListView;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.bFJ.mListView;
            absMsglistView.showNotNotfiy();
        }
    }
}
