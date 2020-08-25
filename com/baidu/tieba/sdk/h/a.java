package com.baidu.tieba.sdk.h;

import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.sdk.b.g;
/* loaded from: classes7.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof String)) {
            String str = (String) customMessage.getData();
            g dpv = com.baidu.tieba.sdk.d.a.dpo().dpv();
            if (dpv != null) {
                dpv.LN(str);
                return null;
            }
            return null;
        }
        return null;
    }
}
