package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.n;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.util.d<CommonMsgPojo> {
    private final /* synthetic */ String bPY;
    final /* synthetic */ PersonalMsglistModel clQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonalMsglistModel personalMsglistModel, String str) {
        this.clQ = personalMsglistModel;
        this.bPY = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: b */
    public void onReturnDataInUI(CommonMsgPojo commonMsgPojo) {
        ChatMessage createMessage;
        if (commonMsgPojo == null) {
            createMessage = this.clQ.createMessage((short) 23, this.bPY);
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(createMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList.add(commonMsgPojo2);
            n.b(new f(this, (PersonalChatMessage) createMessage, linkedList), new g(this, createMessage));
        }
    }
}
