package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage dji;
    final /* synthetic */ e dsK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.dsK = eVar;
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
            personalMsglistModel = this.dsK.dsJ;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.dji);
            personalMsglistModel2 = this.dsK.dsJ;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.dsK.dsJ;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.dsK.dsJ;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.g(msgPageData2);
        }
    }
}
