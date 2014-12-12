package com.baidu.tieba.service;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class e implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        Intent intent = new Intent(TbadkCoreApplication.m255getInst().getContext(), FatalErrorService.class);
        if (com.baidu.tbadk.core.frameworkData.a.START.equals(data)) {
            TbadkCoreApplication.m255getInst().getContext().startService(intent);
            return null;
        } else if (com.baidu.tbadk.core.frameworkData.a.STOP.equals(data)) {
            TbadkCoreApplication.m255getInst().getContext().stopService(intent);
            return null;
        } else {
            return null;
        }
    }
}
