package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements al {
    final /* synthetic */ FloatingPersonalChatActivity dwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dwY = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.al
    public void asv() {
        String str;
        AbsMsglistView absMsglistView;
        MsglistModel msglistModel;
        str = this.dwY.aEZ;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(str, 2)));
        absMsglistView = this.dwY.dbp;
        msglistModel = this.dwY.dbq;
        absMsglistView.refreshGo2New(msglistModel.getData());
    }
}
