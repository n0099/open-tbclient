package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import protobuf.GetOnlineInfo.Game;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements CustomMessageTask.CustomRunnable<Game> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Game> customMessage) {
        if (customMessage == null) {
            return null;
        }
        if (customMessage.getData() != null) {
            MainTabActivity.ccT = customMessage.getData();
        }
        return new CustomResponsedMessage<>(2001258);
    }
}
