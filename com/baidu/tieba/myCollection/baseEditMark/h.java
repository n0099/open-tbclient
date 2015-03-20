package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class h implements CustomMessageTask.CustomRunnable<BaseActivity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.baseEditMark.a> run(CustomMessage<BaseActivity> customMessage) {
        e eVar = null;
        if (customMessage != null && customMessage.getData() != null) {
            eVar = new e(customMessage.getData());
        }
        return new CustomResponsedMessage<>(2001286, eVar);
    }
}
