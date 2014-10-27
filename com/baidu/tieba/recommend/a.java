package com.baidu.tieba.recommend;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.DailyClassicalActivityConfig;
/* loaded from: classes.dex */
class a implements CustomMessageTask.CustomRunnable<DailyClassicalActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<DailyClassicalActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), DailyClassicalActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
