package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bEH;
    final /* synthetic */ e bNS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.bNS = eVar;
        this.bEH = chatMessage;
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
            personalMsglistModel = this.bNS.bNR;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.bEH);
            personalMsglistModel2 = this.bNS.bNR;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.bNS.bNR;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.bNS.bNR;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.d(msgPageData2);
        }
    }
}
