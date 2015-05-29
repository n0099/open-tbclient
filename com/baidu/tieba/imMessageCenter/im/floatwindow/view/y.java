package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ FloatingPersonalChatActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.buJ = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.buJ.mListView;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.buJ.mListView;
            absMsglistView.showNotNotfiy();
        }
    }
}
