package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class t implements CustomMessageTask.CustomRunnable<b> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Object> run(CustomMessage<b> customMessage) {
        if (customMessage != null && (customMessage.getData() instanceof b)) {
            b data = customMessage.getData();
            com.baidu.tbadk.core.util.n.cQ(String.valueOf(data.getId()) + "_" + data.getTitle() + ".tmp");
        }
        return null;
    }
}
