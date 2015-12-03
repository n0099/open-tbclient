package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.recommendfrs.control.a.b;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.InterfaceC0054a<com.baidu.tieba.recommendfrs.data.c> {
    final /* synthetic */ b diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.diG = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.c>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.recommendfrs.data.c> readCacheMessage) {
        long j;
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        if (readCacheMessage == null || readCacheMessage.getRequestData() == null || !(readCacheMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.b)) {
            j = -1;
        } else {
            j = ((com.baidu.tieba.recommendfrs.data.b) readCacheMessage.getRequestData()).awj();
        }
        if (j < 0 && readCacheMessage != null && readCacheRespMsg != null) {
            com.baidu.tbadk.core.log.b.a("frs", readCacheMessage.getClientLogID(), CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE, "readCache", readCacheRespMsg.getError(), "ReadCacheError ContentTag is Null", "ContentTag", Long.valueOf(j));
        }
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
            aVar = this.diG.diF;
            if (aVar != null) {
                aVar2 = this.diG.diF;
                aVar2.a(false, null, false, j);
            }
        } else {
            com.baidu.tieba.recommendfrs.data.c cVar = readCacheRespMsg.getData().get(0);
            aVar3 = this.diG.diF;
            if (aVar3 != null) {
                aVar4 = this.diG.diF;
                aVar4.a(false, cVar, false, j);
            }
        }
        this.diG.c(1, j, 0L);
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.c>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.recommendfrs.data.c> writeCacheMessage) {
    }
}
