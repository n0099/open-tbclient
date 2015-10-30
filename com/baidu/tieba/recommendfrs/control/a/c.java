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
    final /* synthetic */ b cIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cIG = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<g>> readCacheRespMsg, ReadCacheMessage<g> readCacheMessage) {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        String aqk = (readCacheMessage == null || readCacheMessage.getRequestData() == null || !(readCacheMessage.getRequestData() instanceof f)) ? null : ((f) readCacheMessage.getRequestData()).aqk();
        if (aqk != null) {
            if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                aVar = this.cIG.cIF;
                if (aVar != null) {
                    aVar2 = this.cIG.cIF;
                    aVar2.a(false, null, false, aqk);
                }
            } else {
                g gVar = readCacheRespMsg.getData().get(0);
                aVar3 = this.cIG.cIF;
                if (aVar3 != null) {
                    aVar4 = this.cIG.cIF;
                    aVar4.a(false, gVar, false, aqk);
                }
            }
            this.cIG.c(0, aqk, 0);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<g>> writeCacheRespMsg, WriteCacheMessage<g> writeCacheMessage) {
    }
}
