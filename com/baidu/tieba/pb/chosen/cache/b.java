package com.baidu.tieba.pb.chosen.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.squareup.wire.Wire;
import tbclient.ExcPbPage.ExcPbPageResIdl;
/* loaded from: classes22.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        a aVar;
        ExcPbPageResIdl excPbPageResIdl;
        if (customMessage != null && customMessage.getCmd() == 2001314) {
            byte[] bArr = com.baidu.tbadk.core.c.a.bob().AG("tb.pb_normal").get("chosen_pb_page_cache");
            if (bArr != null) {
                try {
                    excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class);
                } catch (Exception e) {
                    excPbPageResIdl = null;
                }
                if (excPbPageResIdl != null && excPbPageResIdl.data != null) {
                    aVar = new a(excPbPageResIdl.data.user_info, excPbPageResIdl.data.thread_info, excPbPageResIdl.data.post_list, excPbPageResIdl.data.user_list);
                    return new ReadChosenPbCacheResponse(aVar);
                }
            }
            aVar = null;
            return new ReadChosenPbCacheResponse(aVar);
        }
        return null;
    }
}
