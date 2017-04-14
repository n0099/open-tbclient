package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.util.f<Boolean> {
    final /* synthetic */ PersonalChatActivity dhj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonalChatActivity personalChatActivity) {
        this.dhj = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.dhj.cOt;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.dhj.cOt;
            absMsglistView.showNotNotfiy();
        }
    }
}
