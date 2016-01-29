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
public class l implements a.InterfaceC0055a<com.baidu.tieba.recommendfrs.data.j> {
    final /* synthetic */ j dEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.dEz = jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.j>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.recommendfrs.data.j> readCacheMessage) {
        int i;
        long j;
        j.a aVar;
        j.a aVar2;
        j.a aVar3;
        j.a aVar4;
        if (readCacheMessage != null) {
            if (readCacheMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.i) {
                i = 2;
                j = ((com.baidu.tieba.recommendfrs.data.i) readCacheMessage.getRequestData()).aFu();
            } else if (readCacheMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.m) {
                i = 3;
                j = ((com.baidu.tieba.recommendfrs.data.m) readCacheMessage.getRequestData()).aFu();
            }
            if (j < 0 && readCacheMessage != null && readCacheRespMsg != null) {
                com.baidu.tbadk.core.log.b.a("frs", readCacheMessage.getClientLogID(), CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE, "readCache", readCacheRespMsg.getError(), "ReadCacheError ContentTag is Null", "ContentTag", Long.valueOf(j));
            }
            if (readCacheRespMsg != null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                aVar = this.dEz.dEv;
                if (aVar != null) {
                    aVar2 = this.dEz.dEv;
                    aVar2.a(false, null, false, j);
                }
            } else {
                com.baidu.tieba.recommendfrs.data.j jVar = readCacheRespMsg.getData().get(0);
                aVar3 = this.dEz.dEv;
                if (aVar3 != null) {
                    aVar4 = this.dEz.dEv;
                    aVar4.a(false, jVar, false, j);
                }
            }
            this.dEz.a(1, j, i, 0L);
        }
        i = 0;
        j = -1;
        if (j < 0) {
            com.baidu.tbadk.core.log.b.a("frs", readCacheMessage.getClientLogID(), CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE, "readCache", readCacheRespMsg.getError(), "ReadCacheError ContentTag is Null", "ContentTag", Long.valueOf(j));
        }
        if (readCacheRespMsg != null) {
        }
        aVar = this.dEz.dEv;
        if (aVar != null) {
        }
        this.dEz.a(1, j, i, 0L);
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.j>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.recommendfrs.data.j> writeCacheMessage) {
    }
}
