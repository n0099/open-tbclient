package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements al {
    final /* synthetic */ FloatingPersonalChatActivity dpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dpU = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.al
    public void apZ() {
        String str;
        AbsMsglistView absMsglistView;
        MsglistModel msglistModel;
        str = this.dpU.aEL;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(str, 2)));
        absMsglistView = this.dpU.cUk;
        msglistModel = this.dpU.cUl;
        absMsglistView.refreshGo2New(msglistModel.getData());
    }
}
