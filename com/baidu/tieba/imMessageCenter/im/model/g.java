package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cnR;
    final /* synthetic */ e cxr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.cxr = eVar;
        this.cnR = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        PersonalMsglistModel personalMsglistModel;
        MsgPageData msgPageData;
        PersonalMsglistModel personalMsglistModel2;
        PersonalMsglistModel personalMsglistModel3;
        com.baidu.adp.base.g gVar;
        PersonalMsglistModel personalMsglistModel4;
        MsgPageData msgPageData2;
        if (bool != null && bool.booleanValue()) {
            personalMsglistModel = this.cxr.cxq;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.cnR);
            personalMsglistModel2 = this.cxr.cxq;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.cxr.cxq;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.cxr.cxq;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.d(msgPageData2);
        }
    }
}
