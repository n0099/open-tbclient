package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestSearchPersonHistoryWriteMessage)) {
            return null;
        }
        RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = (RequestSearchPersonHistoryWriteMessage) customMessage;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        l<String> cB = com.baidu.tbadk.core.c.a.aMT().cB("tb.searchperson_history", currentAccount);
        if (requestSearchPersonHistoryWriteMessage.isClear()) {
            BdCacheService.kd().a(cB);
        } else {
            Object data = requestSearchPersonHistoryWriteMessage.getData();
            if (data == null || !(data instanceof String)) {
                return null;
            }
            cB.setForever((String) data, null);
        }
        return new ResponseSearchPersonHistoryWriteMessage();
    }
}
