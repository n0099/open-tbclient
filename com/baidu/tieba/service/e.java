package com.baidu.tieba.service;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class e implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        String data = customMessage.getData();
        Intent intent = new Intent(TbadkApplication.m252getInst(), FatalErrorService.class);
        if (com.baidu.tbadk.core.frameworkData.a.START.equals(data)) {
            TbadkApplication.m252getInst().startService(intent);
            return null;
        } else if (com.baidu.tbadk.core.frameworkData.a.STOP.equals(data)) {
            TbadkApplication.m252getInst().stopService(intent);
            return null;
        } else {
            return null;
        }
    }
}
