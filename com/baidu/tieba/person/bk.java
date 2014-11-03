package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class bk implements CustomMessageTask.CustomRunnable<PersonInfoActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<PersonInfoActivityConfig> run(CustomMessage<PersonInfoActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            PersonInfoActivityStatic.b(customMessage.getData().getContext(), customMessage.getData().getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_ID), customMessage.getData().getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.USER_NAME), customMessage.getData().getIntent().getStringExtra("from"), customMessage.getData().getIntent().getStringExtra("st_type"));
        }
        return null;
    }
}
