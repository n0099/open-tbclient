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
    public static CustomMessageTask f17804a = new CustomMessageTask(2017000, new CustomMessageTask.CustomRunnable<TbCDNTachometerService.CustomMsgData>() { // from class: com.baidu.tieba.imageProblem.cdnOptimize.Static.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<TbCDNTachometerService.CustomMsgData> customMessage) {
            if (customMessage != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    TbCDNTachometerService.CustomMsgData data = customMessage.getData();
                    if (data != null && data.f17808a != null && data.f17808a.f17821e != null) {
                        String str = "";
                        boolean z = false;
                        if (data.f17815h == null) {
                            if (data.f17809b < data.f17808a.f17821e.size()) {
                                ArrayList<String> arrayList = data.f17808a.f17821e.get(data.f17809b);
                                if (arrayList.size() > 0) {
                                    str = arrayList.get(0);
                                }
                            }
                        } else if (data.f17815h.length() > 0) {
                            str = data.f17815h;
                            z = true;
                        }
                        if (PermissionUtil.isAgreePrivacyPolicy() && str.length() > 0) {
                            data.f17810c = data.f17813f.getTestImageData(data.f17808a.f17819c, str, data.f17808a.f17823g, data.f17808a.f17820d, data.f17814g);
                            data.f17811d = System.currentTimeMillis() - currentTimeMillis;
                            data.f17812e = str;
                            if (z) {
                                data.f17815h = str;
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
        f17804a.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        f17804a.setTaskParallel(new BdAsyncTaskParallel(BdUniqueId.gen(), 10));
    }
}
