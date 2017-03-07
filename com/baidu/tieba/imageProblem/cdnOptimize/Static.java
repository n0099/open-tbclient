package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.r;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.tieba.imageProblem.logic.ImageProblemActivity;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Static {
    private static CustomMessageTask aFK = new CustomMessageTask(CmdConfigCustom.CMD_CDN_TACHOMETER, new CustomMessageTask.CustomRunnable<TbCDNTachometerService.CustomMsgData>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<TbCDNTachometerService.CustomMsgData> customMessage) {
            boolean z;
            if (customMessage != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    TbCDNTachometerService.CustomMsgData data = customMessage.getData();
                    if (data == null || data.ipListData == null || data.ipListData.doA == null) {
                        return null;
                    }
                    String str = "";
                    if (data.doy == null) {
                        if (data.pos < data.ipListData.doA.size()) {
                            ArrayList<String> arrayList = data.ipListData.doA.get(data.pos);
                            if (arrayList.size() > 0) {
                                z = false;
                                str = arrayList.get(0);
                            }
                        }
                        z = false;
                    } else if (data.doy.length() <= 0) {
                        return null;
                    } else {
                        str = data.doy;
                        z = true;
                    }
                    if (str.length() > 0) {
                        data.isSuccess = data.cdnTachometerModel.getTestImageData(data.ipListData.imageUrl, str, data.ipListData.doC, data.ipListData.doz, data.isNormal);
                        data.HD = System.currentTimeMillis() - currentTimeMillis;
                        data.cdnIp = str;
                        if (z) {
                            data.doy = str;
                        }
                        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CDN_TACHOMETER, data);
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return null;
        }
    });

    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<r> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, CDNProblemUploader.m16getInstance());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_CDN_IP_DIRECT_CONNECT, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<e> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CDN_IP_DIRECT_CONNECT, CDNIPDirectConnect.m15getInstance());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        aFK.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        aFK.setTaskParallel(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
        MessageManager.getInstance().registerTask(aFK);
    }
}
