package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage doR;
    final /* synthetic */ e dyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.dyp = eVar;
        this.doR = chatMessage;
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
            personalMsglistModel = this.dyp.dyo;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.doR);
            personalMsglistModel2 = this.dyp.dyo;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.dyp.dyo;
            gVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.dyp.dyo;
            msgPageData2 = personalMsglistModel4.mDatas;
            gVar.g(msgPageData2);
        }
    }
}
