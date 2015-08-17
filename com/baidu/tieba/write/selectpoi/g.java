package com.baidu.tieba.write.selectpoi;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.SearchLocationActivityConfig;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<SearchLocationActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<SearchLocationActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), SearchLocationActivity.class);
            customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra("request_code", 0));
        }
        return null;
    }
}
