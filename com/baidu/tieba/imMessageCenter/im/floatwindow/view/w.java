package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class w implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ FloatingPersonalChatActivity bIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bIA = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.bIA.mListView;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.bIA.mListView;
            absMsglistView.showNotNotfiy();
        }
    }
}
