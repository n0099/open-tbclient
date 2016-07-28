package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
/* loaded from: classes.dex */
class m implements CustomMessageTask.CustomRunnable<PersonalChatActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<PersonalChatActivityConfig> run(CustomMessage<PersonalChatActivityConfig> customMessage) {
        UserData userData;
        if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(userData.getUserId()));
            com.baidu.tbadk.util.u.b(new n(this, linkedList), new o(this, customMessage));
        }
        return null;
    }
}
