package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
/* loaded from: classes3.dex */
public class GuideActivityStatic {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<GuildActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<GuildActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), GuideActivity.class);
                if (!customMessage.getData().startActivity(GuideActivity.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(customMessage.getData().getContext()).createNormalCfg(1)));
                }
            }
            return null;
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015001, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
