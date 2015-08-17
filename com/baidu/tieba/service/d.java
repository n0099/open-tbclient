package com.baidu.tieba.service;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<HashMap<String, String>> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<HashMap<String, String>> customMessage) {
        HashMap<String, String> data = customMessage.getData();
        Intent intent = new Intent(TbadkCoreApplication.m411getInst().getContext(), FatalErrorService.class);
        if (data != null && IntentConfig.START.equals(data.get("type"))) {
            intent.putExtra("uname", data.get("uname"));
            intent.putExtra("uid", data.get("uid"));
            TbadkCoreApplication.m411getInst().getContext().startService(intent);
            return null;
        } else if (IntentConfig.STOP.equals(data)) {
            TbadkCoreApplication.m411getInst().getContext().stopService(intent);
            return null;
        } else {
            return null;
        }
    }
}
