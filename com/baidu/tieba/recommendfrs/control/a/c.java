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
    final /* synthetic */ b csN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.csN = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<g>> readCacheRespMsg, ReadCacheMessage<g> readCacheMessage) {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        String ajK = (readCacheMessage == null || readCacheMessage.getRequestData() == null || !(readCacheMessage.getRequestData() instanceof f)) ? null : ((f) readCacheMessage.getRequestData()).ajK();
        if (ajK != null) {
            if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                aVar = this.csN.csM;
                if (aVar != null) {
                    aVar2 = this.csN.csM;
                    aVar2.a(false, null, false, ajK);
                }
            } else {
                g gVar = readCacheRespMsg.getData().get(0);
                aVar3 = this.csN.csM;
                if (aVar3 != null) {
                    aVar4 = this.csN.csM;
                    aVar4.a(false, gVar, false, ajK);
                }
            }
            this.csN.c(0, ajK, 0);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<g>> writeCacheRespMsg, WriteCacheMessage<g> writeCacheMessage) {
    }
}
