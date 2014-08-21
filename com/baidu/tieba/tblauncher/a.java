package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class a implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.aa> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.atomData.aa> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), GuideActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
