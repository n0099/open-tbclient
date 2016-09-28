package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage dji;
    final /* synthetic */ i dsN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ChatMessage chatMessage) {
        this.dsN = iVar;
        this.dji = chatMessage;
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
            personalMsglistModel = this.dsN.dsJ;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.dji);
            personalMsglistModel2 = this.dsN.dsJ;
            personalMsglistModel2.mLoadDataMode = 15;
            personalMsglistModel3 = this.dsN.dsJ;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.dsN.dsJ;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.g(msgPageData2);
        }
    }
}
