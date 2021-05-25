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
    public static CustomMessageTask f17646a = new CustomMessageTask(2017000, new CustomMessageTask.CustomRunnable<TbCDNTachometerService.CustomMsgData>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<TbCDNTachometerService.CustomMsgData> customMessage) {
            if (customMessage != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    TbCDNTachometerService.CustomMsgData data = customMessage.getData();
                    if (data != null && data.f17650a != null && data.f17650a.f17663e != null) {
                        String str = "";
                        boolean z = false;
                        if (data.f17657h == null) {
                            if (data.f17651b < data.f17650a.f17663e.size()) {
                                ArrayList<String> arrayList = data.f17650a.f17663e.get(data.f17651b);
                                if (arrayList.size() > 0) {
                                    str = arrayList.get(0);
                                }
                            }
                        } else if (data.f17657h.length() > 0) {
                            str = data.f17657h;
                            z = true;
                        }
                        if (PermissionUtil.isAgreePrivacyPolicy() && str.length() > 0) {
                            data.f17652c = data.f17655f.getTestImageData(data.f17650a.f17661c, str, data.f17650a.f17665g, data.f17650a.f17662d, data.f17656g);
                            data.f17653d = System.currentTimeMillis() - currentTimeMillis;
                            data.f17654e = str;
                            if (z) {
                                data.f17657h = str;
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
        f17646a.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        f17646a.setTaskParallel(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
    }
}
