package com.baidu.tieba.pb.history;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.ak;
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
        t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.pb_history", currentAccount);
        if (requestPbHistoryWriteMessage.isClear()) {
            BdCacheService.c().a(b);
        } else {
            Object data = requestPbHistoryWriteMessage.getData();
            if (data == null || !(data instanceof ak)) {
                return null;
            }
            ak akVar = (ak) data;
            b.a(akVar.b(), akVar.a().toString());
        }
        return new ResponsePbHistoryWriteMessage();
    }
}
