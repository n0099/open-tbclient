package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class e implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.tbadkCore.i.a> run(CustomMessage<String> customMessage) {
        return new CustomResponsedMessage<>(2001302, new k());
    }
}
