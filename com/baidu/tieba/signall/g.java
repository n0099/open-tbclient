package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ay;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<ay> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ay> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), SignAllForumActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
