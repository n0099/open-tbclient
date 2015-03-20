package com.baidu.tieba.nightResource;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class a implements CustomMessageTask.CustomRunnable<Boolean> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
        return new CustomResponsedMessage<>(2001288, Boolean.TRUE);
    }
}
