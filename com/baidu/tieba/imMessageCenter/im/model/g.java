package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bXV;
    final /* synthetic */ e chq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.chq = eVar;
        this.bXV = chatMessage;
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
            personalMsglistModel = this.chq.chp;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.bXV);
            personalMsglistModel2 = this.chq.chp;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.chq.chp;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.chq.chp;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.d(msgPageData2);
        }
    }
}
