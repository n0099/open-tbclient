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
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.p;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.tieba.imageProblem.logic.ImageProblemActivity;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class Static {
    private static CustomMessageTask eZP = new CustomMessageTask(2017000, new CustomMessageTask.CustomRunnable<TbCDNTachometerService.CustomMsgData>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<TbCDNTachometerService.CustomMsgData> customMessage) {
            String str;
            boolean z;
            String str2;
            if (customMessage != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    TbCDNTachometerService.CustomMsgData data = customMessage.getData();
                    if (data == null || data.ipListData == null || data.ipListData.eZU == null) {
                        return null;
                    }
                    if (data.eZR == null) {
                        if (data.pos >= data.ipListData.eZU.size()) {
                            z = false;
                            str = "";
                        } else {
                            ArrayList<String> arrayList = data.ipListData.eZU.get(data.pos);
                            if (arrayList.size() <= 0) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(0);
                            }
                            z = false;
                            str = str2;
                        }
                    } else if (data.eZR.length() <= 0) {
                        return null;
                    } else {
                        str = data.eZR;
                        z = true;
                    }
                    if (str.length() > 0) {
                        data.isSuccess = data.cdnTachometerModel.getTestImageData(data.ipListData.imageUrl, str, data.ipListData.eZW, data.ipListData.eZT, data.isNormal);
                        data.NI = System.currentTimeMillis() - currentTimeMillis;
                        data.cdnIp = str;
                        if (z) {
                            data.eZR = str;
                        }
                        return new CustomResponsedMessage<>(2017000, data);
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return null;
        }
    });

    static {
        TbadkCoreApplication.getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016101, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<p> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016101, CDNProblemUploader.getInstance());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2016102, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<e> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016102, CDNIPDirectConnect.getInstance());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        eZP.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        eZP.setTaskParallel(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
        MessageManager.getInstance().registerTask(eZP);
    }
}
