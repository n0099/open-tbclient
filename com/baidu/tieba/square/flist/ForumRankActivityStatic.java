package com.baidu.tieba.square.flist;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SquareForumListActivityConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.square.forumlist.SquareForumListActivity;
import com.baidu.tieba.square.forumlist.SquareForumListResHttpMsg;
import com.baidu.tieba.square.forumlist.SquareForumListResSocketMsg;
import com.baidu.tieba.square.square.f;
import java.util.Map;
/* loaded from: classes8.dex */
public class ForumRankActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(BarFolderFirstDirActivityConfig.class, com.baidu.tieba.square.square.a.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SQUARE_FORUM_LIST, new CustomMessageTask.CustomRunnable<ForumListActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.1
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
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_SQUARE_FORUM_RANK, new CustomMessageTask.CustomRunnable<ForumRankActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ForumRankActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(d.class);
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new CustomMessageTask.CustomRunnable<SingleSquareActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<SingleSquareActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(f.class);
                }
                return null;
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_SQUARE_BAR_FOLDER_FIRST_DIR, new CustomMessageTask.CustomRunnable<BarFolderFirstDirActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<BarFolderFirstDirActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(com.baidu.tieba.square.square.a.class);
                }
                return null;
            }
        });
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(CmdConfigCustom.CMD_SQUARE_FORUM_WEEKLY, new CustomMessageTask.CustomRunnable<SquareForumListActivityConfig>() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.5
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
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SQUARE_FORUM_LIST, SquareForumListResSocketMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003060, com.baidu.tieba.tbadkCore.a.a.bV("c/f/forumsquare/getForumsFromForumClass", CmdConfigSocket.CMD_SQUARE_FORUM_LIST));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(SquareForumListResHttpMsg.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.6
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                String str2 = null;
                if (strArr.length > 2) {
                    str2 = strArr[2];
                }
                if (!StringUtils.isNull(str) && str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIST)) {
                    String substring = str.substring(5);
                    if (!TextUtils.isEmpty(substring)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_RANK, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring, str2)));
                        return 0;
                    }
                }
                return 3;
            }
        });
        bf.bsV().a(UrlSchemaHelper.SCHEMA_TYPE_SQUARE, new bf.b() { // from class: com.baidu.tieba.square.flist.ForumRankActivityStatic.7
            @Override // com.baidu.tbadk.core.util.bf.b
            public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
                if (tbPageContext != null) {
                    new SingleSquareActivityConfig(tbPageContext.getPageActivity()).start();
                }
            }
        });
    }
}
