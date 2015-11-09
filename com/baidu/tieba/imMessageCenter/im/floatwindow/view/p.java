package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements al {
    final /* synthetic */ FloatingPersonalChatActivity bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMS = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.al
    public void onFirstHistoryPageLoaded() {
        String str;
        AbsMsglistView absMsglistView;
        MsglistModel msglistModel;
        str = this.bMS.ayp;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(str, 2)));
        absMsglistView = this.bMS.mListView;
        msglistModel = this.bMS.mListModel;
        absMsglistView.refreshGo2New(msglistModel.getData());
    }
}
