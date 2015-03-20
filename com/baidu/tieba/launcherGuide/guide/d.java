package com.baidu.tieba.launcherGuide.guide;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<NewUserGuideActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<NewUserGuideActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), NewUserGuideActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
