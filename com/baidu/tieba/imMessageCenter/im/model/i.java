package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.util.u;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ PersonalMsglistModel drm;
    private final /* synthetic */ String drp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalMsglistModel personalMsglistModel, String str) {
        this.drm = personalMsglistModel;
        this.drp = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        ChatMessage createMessage;
        if (bool == null || bool.booleanValue()) {
            createMessage = this.drm.createMessage((short) 26, this.drp);
            createMessage.getLocalData().setStatus((short) 0);
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(createMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            u.b(new j(this, (PersonalChatMessage) createMessage, linkedList), new k(this, createMessage));
        }
    }
}
