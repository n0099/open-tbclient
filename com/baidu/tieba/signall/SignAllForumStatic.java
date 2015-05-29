package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class SignAllForumStatic {
    private static com.baidu.tbadk.b.d bIn;
    private static View.OnClickListener mClickListener = new ab();
    private static Context mContext;

    static {
        Ag();
        ac acVar = new ac(2009501);
        acVar.setPriority(3);
        MessageManager.getInstance().registerListener(acVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2009503, null));
        if (TbadkCoreApplication.m411getInst().isMainProcess(true)) {
            TiebaStatic.eventStat(BdBaseApplication.getInst().getApp(), "plugin_signall_static", null);
        }
    }

    private static void Ag() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010030, new ad());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
