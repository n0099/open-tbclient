package com.baidu.tieba.recommend;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.DailyRecommendActivityConfig;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<DailyRecommendActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<DailyRecommendActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), DailyRecommendActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
