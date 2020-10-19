package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.r;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class Static {
    private static CustomMessageTask khn = new CustomMessageTask(CmdConfigCustom.CMD_CDN_TACHOMETER, new CustomMessageTask.CustomRunnable<TbCDNTachometerService.CustomMsgData>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<TbCDNTachometerService.CustomMsgData> customMessage) {
            String str;
            boolean z;
            String str2;
            if (customMessage != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    TbCDNTachometerService.CustomMsgData data = customMessage.getData();
                    if (data == null || data.ipListData == null || data.ipListData.khs == null) {
                        return null;
                    }
                    if (data.khp == null) {
                        if (data.pos >= data.ipListData.khs.size()) {
                            z = false;
                            str = "";
                        } else {
                            ArrayList<String> arrayList = data.ipListData.khs.get(data.pos);
                            if (arrayList.size() <= 0) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(0);
                            }
                            z = false;
                            str = str2;
                        }
                    } else if (data.khp.length() <= 0) {
                        return null;
                    } else {
                        str = data.khp;
                        z = true;
                    }
                    if (ae.bmC() && str.length() > 0) {
                        data.isSuccess = data.cdnTachometerModel.getTestImageData(data.ipListData.imageUrl, str, data.ipListData.khu, data.ipListData.khr, data.isNormal);
                        data.costTime = System.currentTimeMillis() - currentTimeMillis;
                        data.cdnIp = str;
                        if (z) {
                            data.khp = str;
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
        new CustomMessageTask(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<r> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CDN_PROBLEM_UPLOADER, CDNProblemUploader.getInstance());
            }
        }).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        new CustomMessageTask(CmdConfigCustom.CMD_CDN_IP_DIRECT_CONNECT, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<e> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_CDN_IP_DIRECT_CONNECT, CDNIPDirectConnect.getInstance());
            }
        }).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        khn.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        khn.setTaskParallel(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
    }
}
