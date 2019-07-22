package com.baidu.tieba.square.flist;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.square.forumlist.SquareForumListActivity;
import com.baidu.tieba.square.forumlist.SquareForumListResHttpMsg;
import com.baidu.tieba.square.forumlist.SquareForumListResSocketMsg;
import com.baidu.tieba.square.square.BarFolderFirstDirActivity;
import com.baidu.tieba.square.square.SquareActivity;
import java.util.Map;
/* loaded from: classes5.dex */
public class ForumRankActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(BarFolderFirstDirActivityConfig.class, BarFolderFirstDirActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2902025, new CustomMessageTask.CustomRunnable<ForumListActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ForumListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ForumListActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2902028, new CustomMessageTask.CustomRunnable<ForumRankActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ForumRankActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ForumRankActivity.class);
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2902023, new CustomMessageTask.CustomRunnable<SingleSquareActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<SingleSquareActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(SquareActivity.class);
                }
                return null;
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2902026, new CustomMessageTask.CustomRunnable<BarFolderFirstDirActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<BarFolderFirstDirActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(BarFolderFirstDirActivity.class);
                }
                return null;
            }
        });
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(2902029, new CustomMessageTask.CustomRunnable<SquareForumListActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<SquareForumListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(SquareForumListActivity.class);
                }
                return null;
            }
        });
        customMessageTask5.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask5);
        com.baidu.tieba.tbadkCore.a.a.a(309097, SquareForumListResSocketMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SQUARE_FORUM_LIST, com.baidu.tieba.tbadkCore.a.a.bo("c/f/forumsquare/getForumsFromForumClass", 309097));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(SquareForumListResHttpMsg.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        bb.ajC().a(new bb.a() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.6
            @Override // com.baidu.tbadk.core.util.bb.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                String str2 = null;
                if (strArr.length > 2) {
                    str2 = strArr[2];
                }
                if (!StringUtils.isNull(str) && str.startsWith("list:")) {
                    String substring = str.substring(5);
                    if (!TextUtils.isEmpty(substring)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring, str2)));
                        return 0;
                    }
                }
                return 3;
            }
        });
        bb.ajC().a("square:", new bb.b() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.7
            @Override // com.baidu.tbadk.core.util.bb.b
            public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
                if (tbPageContext != null) {
                    new SingleSquareActivityConfig(tbPageContext.getPageActivity()).start();
                }
            }
        });
    }
}
