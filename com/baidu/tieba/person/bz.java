package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class bz implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.at> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.core.atomData.at> run(CustomMessage<com.baidu.tbadk.core.atomData.at> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            PersonInfoActivityStatic.b(customMessage.getData().getContext(), customMessage.getData().getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID), customMessage.getData().getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME));
        }
        return null;
    }
}
