package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
/* loaded from: classes.dex */
class h implements CustomMessageTask.CustomRunnable<GuildActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<GuildActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), GuideActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
