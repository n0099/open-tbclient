package com.baidu.tieba.square.forumlist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes5.dex */
public class SquareForumListStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2902029, new CustomMessageTask.CustomRunnable<SquareForumListActivityConfig>() { // from class: com.baidu.tieba.square.forumlist.SquareForumListStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<SquareForumListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(SquareForumListActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.a(309097, SquareForumListResSocketMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SQUARE_FORUM_LIST, com.baidu.tieba.tbadkCore.a.a.br("c/f/forumsquare/getForumsFromForumClass", 309097));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(SquareForumListResHttpMsg.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
