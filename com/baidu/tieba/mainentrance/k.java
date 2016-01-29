package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k implements CustomMessageTask.CustomRunnable<Object> {
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
        com.baidu.adp.lib.cache.o<String> Q = com.baidu.tbadk.core.b.a.ug().Q("tb.searchperson_history", currentAccount);
        if (requestSearchPersonHistoryWriteMessage.isClear()) {
            BdCacheService.gs().a(Q);
        } else {
            Object data = requestSearchPersonHistoryWriteMessage.getData();
            if (data == null || !(data instanceof String)) {
                return null;
            }
            Q.f((String) data, null);
        }
        return new ResponseSearchPersonHistoryWriteMessage();
    }
}
