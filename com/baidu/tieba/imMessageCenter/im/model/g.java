package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.h;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements h<Boolean> {
    private final /* synthetic */ ChatMessage dlz;
    final /* synthetic */ e dtc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.dtc = eVar;
        this.dlz = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    public void onReturnDataInUI(Boolean bool) {
        PersonalMsglistModel personalMsglistModel;
        MsgPageData msgPageData;
        PersonalMsglistModel personalMsglistModel2;
        PersonalMsglistModel personalMsglistModel3;
        com.baidu.adp.base.f fVar;
        PersonalMsglistModel personalMsglistModel4;
        MsgPageData msgPageData2;
        if (bool != null && bool.booleanValue()) {
            personalMsglistModel = this.dtc.dtb;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.dlz);
            personalMsglistModel2 = this.dtc.dtb;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.dtc.dtb;
            fVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.dtc.dtb;
            msgPageData2 = personalMsglistModel4.mDatas;
            fVar.g(msgPageData2);
        }
    }
}
