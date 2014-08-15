package com.baidu.tieba.image;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.af;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<af> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<af> customMessage) {
        if (customMessage != null && customMessage.getData() != null && "data_valid".equals(customMessage.getData().getIntent().getStringExtra("is_data_valid"))) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), ImageViewerActivity.class);
            if ("start_activity_normal".equals(customMessage.getData().getIntent().getStringExtra("start_activity_type"))) {
                customMessage.getData().startActivity();
            } else {
                customMessage.getData().startActivityForResult(14001);
            }
        }
        return null;
    }
}
