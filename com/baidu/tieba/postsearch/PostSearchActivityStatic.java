package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class PostSearchActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PostSearchActivityConfig.class, PostSearchActivity.class);
        cxW();
        cxX();
        cxY();
    }

    private static void cxW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003016, TbConfig.SERVER_ADDRESS + TbConfig.POST_SEARCH_URL);
        tbHttpMessageTask.setResponsedClass(PostSearchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cxX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.SAVE_SEARCH_POST_DATA, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.postsearch.PostSearchActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                String data = customMessage.getData();
                if (StringUtils.isNull(data)) {
                    return null;
                }
                com.baidu.tieba.tbadkCore.util.a.IM(data);
                return new CustomResponsedMessage<>(CmdConfigCustom.SAVE_SEARCH_POST_DATA);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cxY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.postsearch.PostSearchActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Void> run(CustomMessage<Void> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                com.baidu.tieba.tbadkCore.util.a.cJp();
                return new CustomResponsedMessage<>(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
