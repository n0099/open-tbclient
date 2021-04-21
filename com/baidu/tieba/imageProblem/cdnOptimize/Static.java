package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class Static {

    /* renamed from: a  reason: collision with root package name */
    public static CustomMessageTask f18076a = new CustomMessageTask(2017000, new CustomMessageTask.CustomRunnable<TbCDNTachometerService.CustomMsgData>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<TbCDNTachometerService.CustomMsgData> customMessage) {
            if (customMessage != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    TbCDNTachometerService.CustomMsgData data = customMessage.getData();
                    if (data != null && data.f18080a != null && data.f18080a.f18092e != null) {
                        String str = "";
                        boolean z = false;
                        if (data.f18087h == null) {
                            if (data.f18081b < data.f18080a.f18092e.size()) {
                                ArrayList<String> arrayList = data.f18080a.f18092e.get(data.f18081b);
                                if (arrayList.size() > 0) {
                                    str = arrayList.get(0);
                                }
                            }
                        } else if (data.f18087h.length() > 0) {
                            str = data.f18087h;
                            z = true;
                        }
                        if (PermissionUtil.isAgreePrivacyPolicy() && str.length() > 0) {
                            data.f18082c = data.f18085f.getTestImageData(data.f18080a.f18090c, str, data.f18080a.f18094g, data.f18080a.f18091d, data.f18086g);
                            data.f18083d = System.currentTimeMillis() - currentTimeMillis;
                            data.f18084e = str;
                            if (z) {
                                data.f18087h = str;
                            }
                            return new CustomResponsedMessage<>(2017000, data);
                        }
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
    });

    static {
        new CustomMessageTask(2016101, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ICDNProblemUploader> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016101, CDNProblemUploader.getInstance());
            }
        }).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        new CustomMessageTask(2016102, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ICDNIPDirectConnect> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016102, CDNIPDirectConnect.getInstance());
            }
        }).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        f18076a.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        f18076a.setTaskParallel(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
    }
}
