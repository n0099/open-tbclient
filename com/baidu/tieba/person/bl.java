package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* loaded from: classes.dex */
class bl implements CustomMessageTask.CustomRunnable<PersonInfoActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<PersonInfoActivityConfig> run(CustomMessage<PersonInfoActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            PersonInfoActivityStatic.a(customMessage.getData());
        }
        return null;
    }
}
