package com.baidu.tieba.pb.history;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.s;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.aj;
/* loaded from: classes.dex */
public class j implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestPbHistoryWriteMessage)) {
            return null;
        }
        RequestPbHistoryWriteMessage requestPbHistoryWriteMessage = (RequestPbHistoryWriteMessage) customMessage;
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        s<String> a = com.baidu.tbadk.core.a.b.a().a(currentAccount);
        if (requestPbHistoryWriteMessage.isClear()) {
            BdCacheService.c().a(a);
        } else {
            Object data = requestPbHistoryWriteMessage.getData();
            if (data == null || !(data instanceof aj)) {
                return null;
            }
            aj ajVar = (aj) data;
            a.a(ajVar.b(), ajVar.a().toString());
        }
        return new ResponsePbHistoryWriteMessage();
    }
}
