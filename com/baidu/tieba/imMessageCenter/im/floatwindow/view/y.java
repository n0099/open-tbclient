package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class y implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ FloatingPersonalChatActivity brH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.brH = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.brH.mListView;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.brH.mListView;
            absMsglistView.showNotNotfiy();
        }
    }
}
