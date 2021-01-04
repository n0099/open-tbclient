package com.baidu.tieba.sdk.g;

import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
/* loaded from: classes11.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
        boolean z = true;
        if (com.baidu.tieba.sdk.d.a.dHb().dHk() != null) {
            z = com.baidu.tieba.sdk.d.a.dHb().dHk().dfr();
        }
        return new CustomResponsedMessage<>(2913260, Boolean.valueOf(z));
    }
}
