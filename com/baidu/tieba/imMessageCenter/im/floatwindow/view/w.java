package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class w implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ FloatingPersonalChatActivity cfW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.cfW = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        AbsMsglistView absMsglistView;
        AbsMsglistView absMsglistView2;
        if (bool != null) {
            if (bool.booleanValue()) {
                absMsglistView2 = this.cfW.mListView;
                absMsglistView2.closeNotNotify();
                return;
            }
            absMsglistView = this.cfW.mListView;
            absMsglistView.showNotNotfiy();
        }
    }
}
