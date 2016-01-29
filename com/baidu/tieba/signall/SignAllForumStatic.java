package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes.dex */
public class SignAllForumStatic {
    private static View.OnClickListener OS = new ab();
    private static com.baidu.tbadk.d.d cGi;
    private static Context mContext;

    static {
        DW();
        ac acVar = new ac(CmdConfigCustom.DISCOVER_ADD_VIEW);
        acVar.setPriority(3);
        MessageManager.getInstance().registerListener(acVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DISCOVER_NEED_ADD_VIEW, null));
        aJp();
        TbadkCoreApplication.m411getInst().RegisterIntent(SignAllForumAdvertActivityConfig.class, SignAllForumAdvertActivity.class);
    }

    private static void DW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new ad());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aJp() {
        be.wt().a(new ae());
    }
}
