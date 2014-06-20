package com.baidu.tieba.pb.praise;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.au;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<au> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<au> run(CustomMessage<au> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            PraiseListActivity.b(customMessage.getData().getContext(), customMessage.getData().getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID), customMessage.getData().getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID), customMessage.getData().getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.POST_DESC), customMessage.getData().getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_FROM_PB, true));
        }
        return null;
    }
}
