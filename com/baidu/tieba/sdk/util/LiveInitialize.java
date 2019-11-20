package com.baidu.tieba.sdk.util;

import android.app.Activity;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.account.AccountLoginCoreHelper;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes6.dex */
public class LiveInitialize {
    static {
        registerTask();
    }

    private static void registerTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.sdk.util.LiveInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<AccountLoginCoreHelper> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, a.chU());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
