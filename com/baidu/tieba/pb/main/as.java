package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class as implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.ar> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.atomData.ar> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), PbActivity.class);
            if (TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK.equals(customMessage.getData().getIntent().getStringExtra("is_start_for_result"))) {
                customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, 0));
            } else {
                customMessage.getData().startActivity();
            }
        }
        return null;
    }
}
