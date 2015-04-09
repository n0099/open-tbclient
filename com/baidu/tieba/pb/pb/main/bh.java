package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class bh implements CustomMessageTask.CustomRunnable<PbActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<PbActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), PbActivity.class);
            if ("1".equals(customMessage.getData().getIntent().getStringExtra(PbActivityConfig.KYE_IS_START_FOR_RESULT))) {
                customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, 0));
            } else {
                customMessage.getData().startActivity();
            }
        }
        return null;
    }
}
