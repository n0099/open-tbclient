package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ PersonalChatActivity cth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalChatActivity personalChatActivity) {
        this.cth = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.cth.caG;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.cth.caG;
            absMsglistView.showNotNotfiy();
        }
    }
}
