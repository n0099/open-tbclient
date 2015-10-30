package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
class s implements CustomMessageTask.CustomRunnable<b> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<List<b>> run(CustomMessage<b> customMessage) {
        if (customMessage == null || !(customMessage.getData() instanceof b)) {
            return null;
        }
        b data = customMessage.getData();
        if (l.azo().lu(data.getId())) {
            com.baidu.tbadk.core.util.n.cR(String.valueOf(data.getId()) + ".apk");
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_READ_SKIN_DATA_FROM_DB, l.azo().azq());
        }
        return null;
    }
}
