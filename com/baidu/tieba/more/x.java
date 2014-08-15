package com.baidu.tieba.more;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class x implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.frameworkData.a> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.frameworkData.a> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), MoreActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
