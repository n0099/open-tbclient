package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class SignAllForumStatic {
    private static View.OnClickListener OZ = new ab();
    private static com.baidu.tbadk.d.d ehc;
    private static Context mContext;

    static {
        EH();
        ac acVar = new ac(CmdConfigCustom.DISCOVER_ADD_VIEW);
        acVar.setPriority(3);
        MessageManager.getInstance().registerListener(acVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DISCOVER_NEED_ADD_VIEW, null));
        aQf();
        TbadkCoreApplication.m411getInst().RegisterIntent(SignAllForumAdvertActivityConfig.class, SignAllForumAdvertActivity.class);
    }

    private static void EH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new ad());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aQf() {
        bg.wM().a(new ae());
    }
}
