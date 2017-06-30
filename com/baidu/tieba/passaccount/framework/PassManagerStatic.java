package com.baidu.tieba.passaccount.framework;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.QALoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.passaccount.app.LoginActivity;
import com.baidu.tieba.passaccount.app.QALoginActivity;
import com.baidu.tieba.passaccount.app.SapiFastRegActivity;
/* loaded from: classes.dex */
public class PassManagerStatic {
    static {
        KG();
        DU();
        registerListener();
    }

    private static void KG() {
        com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
        if (!com.baidu.tbadk.coreExtra.a.a.xu()) {
            TbadkCoreApplication.m9getInst().RegisterOrUpdateIntent(RegisterActivityConfig.class, SapiFastRegActivity.class);
        }
        TbadkCoreApplication.m9getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
        TbadkCoreApplication.m9getInst().RegisterOrUpdateIntent(QALoginActivityConfig.class, QALoginActivity.class);
    }

    private static void DU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_PASS_MANAGER, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_ACCOUT_LOGIN_HELPER, new b());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.UEXCEPTION_MESSAGE));
        be.vP().a(new d());
    }
}
