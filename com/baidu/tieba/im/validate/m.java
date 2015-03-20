package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class m implements CustomMessageTask.CustomRunnable<Void> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
        return new CustomResponsedMessage<>(2001294, Integer.valueOf(u.icon_new_test));
    }
}
