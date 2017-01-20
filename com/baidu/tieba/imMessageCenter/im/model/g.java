package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage daW;
    final /* synthetic */ e diA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.diA = eVar;
        this.daW = chatMessage;
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
            personalMsglistModel = this.diA.diz;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.daW);
            personalMsglistModel2 = this.diA.diz;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.diA.diz;
            fVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.diA.diz;
            msgPageData2 = personalMsglistModel4.mDatas;
            fVar.g(msgPageData2);
        }
    }
}
