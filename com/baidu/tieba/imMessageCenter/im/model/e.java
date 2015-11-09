package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.util.d<CommonMsgPojo> {
    final /* synthetic */ PersonalMsglistModel bOm;
    private final /* synthetic */ String btj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonalMsglistModel personalMsglistModel, String str) {
        this.bOm = personalMsglistModel;
        this.btj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: b */
    public void onReturnDataInUI(CommonMsgPojo commonMsgPojo) {
        ChatMessage createMessage;
        if (commonMsgPojo == null) {
            createMessage = this.bOm.createMessage((short) 23, this.btj);
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(createMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList.add(commonMsgPojo2);
            m.b(new f(this, (PersonalChatMessage) createMessage, linkedList), new g(this, createMessage));
        }
    }
}
