package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements al {
    final /* synthetic */ FloatingPersonalChatActivity drr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.drr = floatingPersonalChatActivity;
    }

    @Override // com.baidu.tieba.im.chat.al
    public void aqy() {
        String str;
        AbsMsglistView absMsglistView;
        MsglistModel msglistModel;
        str = this.drr.aEj;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(str, 2)));
        absMsglistView = this.drr.cVE;
        msglistModel = this.drr.cVF;
        absMsglistView.refreshGo2New(msglistModel.getData());
    }
}
