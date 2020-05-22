package com.baidu.tieba.sdk.util;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.account.AccountLoginCoreHelper;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes3.dex */
public class LiveInitialize {
    static {
        Fv();
    }

    private static void Fv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.sdk.util.LiveInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<AccountLoginCoreHelper> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.cWD());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
