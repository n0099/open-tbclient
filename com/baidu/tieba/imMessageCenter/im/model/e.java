package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.q;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.util.g<CommonMsgPojo> {
    private final /* synthetic */ String caq;
    final /* synthetic */ PersonalMsglistModel cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonalMsglistModel personalMsglistModel, String str) {
        this.cwt = personalMsglistModel;
        this.caq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: b */
    public void onReturnDataInUI(CommonMsgPojo commonMsgPojo) {
        ChatMessage createMessage;
        if (commonMsgPojo == null) {
            createMessage = this.cwt.createMessage((short) 23, this.caq);
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(createMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList.add(commonMsgPojo2);
            q.b(new f(this, (PersonalChatMessage) createMessage, linkedList), new g(this, createMessage));
        }
    }
}
