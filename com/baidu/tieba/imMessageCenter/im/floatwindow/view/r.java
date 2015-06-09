package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.ax;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements ax {
    final /* synthetic */ FloatingPersonalChatActivity buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.buK = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.ax
    public void onFirstHistoryPageLoaded() {
        String str;
        AbsMsglistView absMsglistView;
        MsglistModel msglistModel;
        str = this.buK.ase;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(str, 2)));
        absMsglistView = this.buK.mListView;
        msglistModel = this.buK.mListModel;
        absMsglistView.refreshGo2New(msglistModel.getData());
    }
}
