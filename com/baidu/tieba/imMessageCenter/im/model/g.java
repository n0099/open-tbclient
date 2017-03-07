package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage ddo;
    final /* synthetic */ e dkS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.dkS = eVar;
        this.ddo = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        PersonalMsglistModel personalMsglistModel;
        MsgPageData msgPageData;
        PersonalMsglistModel personalMsglistModel2;
        PersonalMsglistModel personalMsglistModel3;
        com.baidu.adp.base.f fVar;
        PersonalMsglistModel personalMsglistModel4;
        MsgPageData msgPageData2;
        if (bool != null && bool.booleanValue()) {
            personalMsglistModel = this.dkS.dkR;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.ddo);
            personalMsglistModel2 = this.dkS.dkR;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.dkS.dkR;
            fVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.dkS.dkR;
            msgPageData2 = personalMsglistModel4.mDatas;
            fVar.g(msgPageData2);
        }
    }
}
