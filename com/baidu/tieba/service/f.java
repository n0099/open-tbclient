package com.baidu.tieba.service;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
class f implements CustomMessageTask.CustomRunnable<HashMap<String, String>> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<HashMap<String, String>> customMessage) {
        HashMap<String, String> data = customMessage.getData();
        Intent intent = new Intent(TbadkCoreApplication.m411getInst().getContext(), FatalErrorService.class);
        if (data != null && com.baidu.tbadk.core.frameworkData.a.START.equals(data.get("type"))) {
            intent.putExtra("uname", data.get("uname"));
            intent.putExtra(SapiAccountManager.SESSION_UID, data.get(SapiAccountManager.SESSION_UID));
            TbadkCoreApplication.m411getInst().getContext().startService(intent);
            return null;
        } else if (com.baidu.tbadk.core.frameworkData.a.STOP.equals(data)) {
            TbadkCoreApplication.m411getInst().getContext().stopService(intent);
            return null;
        } else {
            return null;
        }
    }
}
