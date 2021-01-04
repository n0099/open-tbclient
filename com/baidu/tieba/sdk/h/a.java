package com.baidu.tieba.sdk.h;

import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.sdk.b.f;
/* loaded from: classes11.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof String)) {
            String str = (String) customMessage.getData();
            f dHl = com.baidu.tieba.sdk.d.a.dHb().dHl();
            if (dHl != null) {
                dHl.Oh(str);
                return null;
            }
            return null;
        }
        return null;
    }
}
