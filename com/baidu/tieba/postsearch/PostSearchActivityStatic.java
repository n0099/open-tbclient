package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes6.dex */
public class PostSearchActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PostSearchActivityConfig.class, PostSearchActivity.class);
        cdj();
        cdk();
        cdl();
    }

    private static void cdj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_POST_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.POST_SEARCH_URL);
        tbHttpMessageTask.setResponsedClass(PostSearchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cdk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009003, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.postsearch.PostSearchActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                String data = customMessage.getData();
                if (StringUtils.isNull(data)) {
                    return null;
                }
                com.baidu.tieba.tbadkCore.util.a.Ef(data);
                return new CustomResponsedMessage<>(2009003);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cdl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009004, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.postsearch.PostSearchActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Void> run(CustomMessage<Void> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                com.baidu.tieba.tbadkCore.util.a.cnp();
                return new CustomResponsedMessage<>(2009004);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
