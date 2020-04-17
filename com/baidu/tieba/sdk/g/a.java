package com.baidu.tieba.sdk.g;

import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.sdk.a.g;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof String)) {
            String str = (String) customMessage.getData();
            g cPp = com.baidu.tieba.sdk.c.a.cPj().cPp();
            if (cPp != null) {
                cPp.FS(str);
                return null;
            }
            return null;
        }
        return null;
    }
}
