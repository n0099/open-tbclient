package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class h implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
        if (customMessage == null) {
            return null;
        }
        String data = customMessage.getData();
        if (StringUtils.isNull(data)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.util.j.jI(data);
        return new CustomResponsedMessage<>(2009003);
    }
}
