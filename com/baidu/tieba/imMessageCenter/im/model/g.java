package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage ccp;
    final /* synthetic */ e clR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.clR = eVar;
        this.ccp = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        PersonalMsglistModel personalMsglistModel;
        MsgPageData msgPageData;
        PersonalMsglistModel personalMsglistModel2;
        PersonalMsglistModel personalMsglistModel3;
        com.baidu.adp.base.g gVar;
        PersonalMsglistModel personalMsglistModel4;
        MsgPageData msgPageData2;
        if (bool != null && bool.booleanValue()) {
            personalMsglistModel = this.clR.clQ;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.ccp);
            personalMsglistModel2 = this.clR.clQ;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.clR.clQ;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.clR.clQ;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.d(msgPageData2);
        }
    }
}
