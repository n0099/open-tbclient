package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ak;
/* loaded from: classes.dex */
class k implements CustomMessageTask.CustomRunnable<ak> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ak> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), MainTabActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
