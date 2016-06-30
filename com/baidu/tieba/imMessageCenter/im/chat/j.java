package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ PersonalChatActivity cYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalChatActivity personalChatActivity) {
        this.cYx = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.cYx.cFQ;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.cYx.cFQ;
            absMsglistView.showNotNotfiy();
        }
    }
}
