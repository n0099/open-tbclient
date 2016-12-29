package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage cTM;
    final /* synthetic */ e dbn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.dbn = eVar;
        this.cTM = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        PersonalMsglistModel personalMsglistModel;
        MsgPageData msgPageData;
        PersonalMsglistModel personalMsglistModel2;
        PersonalMsglistModel personalMsglistModel3;
        com.baidu.adp.base.g gVar;
        PersonalMsglistModel personalMsglistModel4;
        MsgPageData msgPageData2;
        if (bool != null && bool.booleanValue()) {
            personalMsglistModel = this.dbn.dbm;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.cTM);
            personalMsglistModel2 = this.dbn.dbm;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.dbn.dbm;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.dbn.dbm;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.g(msgPageData2);
        }
    }
}
