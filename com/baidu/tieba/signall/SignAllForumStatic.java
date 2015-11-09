package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class SignAllForumStatic {
    private static com.baidu.tbadk.c.d cdA;
    private static View.OnClickListener mClickListener = new w();
    private static Context mContext;

    static {
        BP();
        x xVar = new x(CmdConfigCustom.DISCOVER_ADD_VIEW);
        xVar.setPriority(3);
        MessageManager.getInstance().registerListener(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.DISCOVER_NEED_ADD_VIEW, null));
    }

    private static void BP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new y());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
