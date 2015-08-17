package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.UserMuteListActivityConfig;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<UserMuteListActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<UserMuteListActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().startActivity(UserMuteListActivity.class);
        }
        return null;
    }
}
