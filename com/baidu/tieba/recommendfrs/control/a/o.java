package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.recommendfrs.control.a.m;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.InterfaceC0055a<com.baidu.tieba.recommendfrs.data.n> {
    final /* synthetic */ m dWx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.dWx = mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.n>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.recommendfrs.data.n> readCacheMessage) {
        int i;
        long j;
        m.a aVar;
        m.a aVar2;
        m.a aVar3;
        m.a aVar4;
        if (readCacheMessage != null) {
            if (readCacheMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.m) {
                i = 2;
                j = ((com.baidu.tieba.recommendfrs.data.m) readCacheMessage.getRequestData()).aMi();
            } else if (readCacheMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.q) {
                i = 3;
                j = ((com.baidu.tieba.recommendfrs.data.q) readCacheMessage.getRequestData()).aMi();
            }
            if (j < 0 && readCacheMessage != null && readCacheRespMsg != null) {
                com.baidu.tbadk.core.log.b.a("frs", readCacheMessage.getClientLogID(), CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE, "readCache", readCacheRespMsg.getError(), "ReadCacheError ContentTag is Null", "ContentTag", Long.valueOf(j));
            }
            if (readCacheRespMsg != null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                aVar = this.dWx.dWt;
                if (aVar != null) {
                    aVar2 = this.dWx.dWt;
                    aVar2.a(false, null, false, j);
                }
            } else {
                com.baidu.tieba.recommendfrs.data.n nVar = readCacheRespMsg.getData().get(0);
                aVar3 = this.dWx.dWt;
                if (aVar3 != null) {
                    aVar4 = this.dWx.dWt;
                    aVar4.a(false, nVar, false, j);
                }
            }
            this.dWx.a(1, j, i, 0L);
        }
        i = 0;
        j = -1;
        if (j < 0) {
            com.baidu.tbadk.core.log.b.a("frs", readCacheMessage.getClientLogID(), CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE, "readCache", readCacheRespMsg.getError(), "ReadCacheError ContentTag is Null", "ContentTag", Long.valueOf(j));
        }
        if (readCacheRespMsg != null) {
        }
        aVar = this.dWx.dWt;
        if (aVar != null) {
        }
        this.dWx.a(1, j, i, 0L);
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.n>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.recommendfrs.data.n> writeCacheMessage) {
    }
}
