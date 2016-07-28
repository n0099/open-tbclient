package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cWb;
    final /* synthetic */ e dfG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.dfG = eVar;
        this.cWb = chatMessage;
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
            personalMsglistModel = this.dfG.dfF;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.cWb);
            personalMsglistModel2 = this.dfG.dfF;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.dfG.dfF;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.dfG.dfF;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.g(msgPageData2);
        }
    }
}
