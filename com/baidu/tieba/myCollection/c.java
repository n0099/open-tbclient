package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class c implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.frameworkData.a> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.frameworkData.a> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), EditMarkActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
