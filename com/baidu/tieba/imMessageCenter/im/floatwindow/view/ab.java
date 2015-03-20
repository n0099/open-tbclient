package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements CustomMessageTask.CustomRunnable<FloatingPersonalChatActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<FloatingPersonalChatActivityConfig> run(CustomMessage<FloatingPersonalChatActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            FloatingPersonalChatActivityStatic.mUserDataList = customMessage.getData().getUserDataList();
            UserData userData = customMessage.getData().getUserData();
            if (userData != null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(String.valueOf(userData.getUserId()));
                com.baidu.tieba.im.l.a(new ac(this, linkedList), new ad(this, customMessage));
            }
        }
        return null;
    }
}
