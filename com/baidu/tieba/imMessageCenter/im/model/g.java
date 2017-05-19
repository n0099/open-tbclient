package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cYd;
    final /* synthetic */ e dfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ChatMessage chatMessage) {
        this.dfM = eVar;
        this.cYd = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        PersonalMsglistModel personalMsglistModel;
        MsgPageData msgPageData;
        PersonalMsglistModel personalMsglistModel2;
        PersonalMsglistModel personalMsglistModel3;
        com.baidu.adp.base.f fVar;
        PersonalMsglistModel personalMsglistModel4;
        MsgPageData msgPageData2;
        if (bool != null && bool.booleanValue()) {
            personalMsglistModel = this.dfM.dfL;
            msgPageData = personalMsglistModel.mDatas;
            msgPageData.getChatMessages().add(this.cYd);
            personalMsglistModel2 = this.dfM.dfL;
            personalMsglistModel2.mLoadDataMode = 14;
            personalMsglistModel3 = this.dfM.dfL;
            fVar = personalMsglistModel3.mLoadDataCallBack;
            personalMsglistModel4 = this.dfM.dfL;
            msgPageData2 = personalMsglistModel4.mDatas;
            fVar.g(msgPageData2);
        }
    }
}
