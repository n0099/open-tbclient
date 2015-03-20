package com.baidu.tieba.pb.chosen.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.squareup.wire.Wire;
import tbclient.FinePbPage.FinePbPageResIdl;
/* loaded from: classes.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        a aVar;
        FinePbPageResIdl finePbPageResIdl;
        if (customMessage != null && customMessage.getCmd() == 2001321) {
            byte[] bArr = com.baidu.tbadk.core.b.a.rc().bW("tb.pb_normal").get("chosen_pb_page_cache");
            if (bArr != null) {
                try {
                    finePbPageResIdl = (FinePbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FinePbPageResIdl.class);
                } catch (Exception e) {
                    finePbPageResIdl = null;
                }
                if (finePbPageResIdl != null && finePbPageResIdl.data != null) {
                    aVar = new a(finePbPageResIdl.data.prevftid.longValue(), finePbPageResIdl.data.nextftid.longValue(), finePbPageResIdl.data.user_info, finePbPageResIdl.data.thread_info);
                    return new ReadChosenPbCacheResponse(aVar);
                }
            }
            aVar = null;
            return new ReadChosenPbCacheResponse(aVar);
        }
        return null;
    }
}
