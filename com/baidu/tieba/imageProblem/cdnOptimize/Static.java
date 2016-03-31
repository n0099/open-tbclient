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
    private static CustomMessageTask aAW = new CustomMessageTask(CmdConfigCustom.CMD_CDN_TACHOMETER, new CustomMessageTask.CustomRunnable<TbCDNTachometerService.CustomMsgData>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<TbCDNTachometerService.CustomMsgData> customMessage) {
            boolean z;
            if (customMessage != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    TbCDNTachometerService.CustomMsgData data = customMessage.getData();
                    if (data == null || data.ipListData == null || data.ipListData.czR == null) {
                        return null;
                    }
                    String str = "";
                    if (data.czP == null) {
                        if (data.pos < data.ipListData.czR.size()) {
                            ArrayList<String> arrayList = data.ipListData.czR.get(data.pos);
                            if (arrayList.size() > 0) {
                                z = false;
                                str = arrayList.get(0);
                            }
                        }
                        z = false;
                    } else if (data.czP.length() <= 0) {
                        return null;
                    } else {
                        str = data.czP;
                        z = true;
                    }
                    if (str.length() > 0) {
                        data.isSuccess = data.cdnTachometerModel.getTestImageData(data.ipListData.imageUrl, str, data.ipListData.czT, data.ipListData.czQ, data.isNormal);
                        data.Hs = System.currentTimeMillis() - currentTimeMillis;
                        data.cdnIp = str;
                        if (z) {
                            data.czP = str;
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
        TbadkCoreApplication.m411getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<r> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, CDNProblemUploader.m414getInstance());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_CDN_IP_DIRECT_CONNECT, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<e> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CDN_IP_DIRECT_CONNECT, CDNIPDirectConnect.m413getInstance());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        aAW.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        aAW.setTaskParallel(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
        MessageManager.getInstance().registerTask(aAW);
    }
}
