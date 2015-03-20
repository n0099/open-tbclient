package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ImMessageCenterActivityConfig;
/* loaded from: classes.dex */
class a implements CustomMessageTask.CustomRunnable<ImMessageCenterActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ImMessageCenterActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), ImMessageCenterActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
