package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.recommendfrs.control.a.j;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0054a<com.baidu.tieba.recommendfrs.data.h> {
    final /* synthetic */ j dpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.dpb = jVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.h>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.recommendfrs.data.h> readCacheMessage) {
        long j;
        j.a aVar;
        j.a aVar2;
        j.a aVar3;
        j.a aVar4;
        if (readCacheMessage == null || readCacheMessage.getRequestData() == null || !(readCacheMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.g)) {
            j = -1;
        } else {
            j = ((com.baidu.tieba.recommendfrs.data.g) readCacheMessage.getRequestData()).ayp();
        }
        if (j < 0 && readCacheMessage != null && readCacheRespMsg != null) {
            com.baidu.tbadk.core.log.b.a("frs", readCacheMessage.getClientLogID(), CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE, "readCache", readCacheRespMsg.getError(), "ReadCacheError ContentTag is Null", "ContentTag", Long.valueOf(j));
        }
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
            aVar = this.dpb.doZ;
            if (aVar != null) {
                aVar2 = this.dpb.doZ;
                aVar2.a(false, null, false, j);
            }
        } else {
            com.baidu.tieba.recommendfrs.data.h hVar = readCacheRespMsg.getData().get(0);
            aVar3 = this.dpb.doZ;
            if (aVar3 != null) {
                aVar4 = this.dpb.doZ;
                aVar4.a(false, hVar, false, j);
            }
        }
        this.dpb.c(1, j, 0L);
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.h>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.recommendfrs.data.h> writeCacheMessage) {
    }
}
