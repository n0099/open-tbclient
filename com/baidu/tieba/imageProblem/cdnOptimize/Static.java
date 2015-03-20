package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.util.httpNet.e;
import com.baidu.tbadk.core.util.r;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.tieba.imageProblem.logic.ImageProblemActivity;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
/* loaded from: classes.dex */
public class Static {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016101, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<r> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016101, CDNProblemUploader.m414getInstance());
            }
        });
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2016102, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<e> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016102, CDNIPDirectConnect.m413getInstance());
            }
        });
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
