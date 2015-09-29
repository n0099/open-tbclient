package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bEw;
    final /* synthetic */ e bNH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.bNH = eVar;
        this.bEw = chatMessage;
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
            personalMsglistModel = this.bNH.bNG;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.bEw);
            personalMsglistModel2 = this.bNH.bNG;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.bNH.bNG;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.bNH.bNG;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.d(msgPageData2);
        }
    }
}
