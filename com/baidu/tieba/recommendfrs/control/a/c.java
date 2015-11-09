package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.recommendfrs.control.a.b;
import com.baidu.tieba.recommendfrs.data.f;
import com.baidu.tieba.recommendfrs.data.g;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.InterfaceC0052a<g> {
    final /* synthetic */ b cKc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cKc = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<g>> readCacheRespMsg, ReadCacheMessage<g> readCacheMessage) {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        String aqQ = (readCacheMessage == null || readCacheMessage.getRequestData() == null || !(readCacheMessage.getRequestData() instanceof f)) ? null : ((f) readCacheMessage.getRequestData()).aqQ();
        if (aqQ != null) {
            if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                aVar = this.cKc.cKb;
                if (aVar != null) {
                    aVar2 = this.cKc.cKb;
                    aVar2.a(false, null, false, aqQ);
                }
            } else {
                g gVar = readCacheRespMsg.getData().get(0);
                aVar3 = this.cKc.cKb;
                if (aVar3 != null) {
                    aVar4 = this.cKc.cKb;
                    aVar4.a(false, gVar, false, aqQ);
                }
            }
            this.cKc.c(0, aqQ, 0);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<g>> writeCacheRespMsg, WriteCacheMessage<g> writeCacheMessage) {
    }
}
