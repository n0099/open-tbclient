package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.model.d<com.baidu.tieba.recommendfrs.data.f> {
    final /* synthetic */ b cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cbR = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.f>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.recommendfrs.data.f> readCacheMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        String ahB = (readCacheMessage == null || readCacheMessage.getRequestData() == null || !(readCacheMessage.getRequestData() instanceof com.baidu.tieba.recommendfrs.data.e)) ? null : ((com.baidu.tieba.recommendfrs.data.e) readCacheMessage.getRequestData()).ahB();
        if (ahB != null) {
            if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                eVar = this.cbR.cbQ;
                if (eVar != null) {
                    eVar2 = this.cbR.cbQ;
                    eVar2.a(false, null, false, ahB);
                }
            } else {
                com.baidu.tieba.recommendfrs.data.f fVar = readCacheRespMsg.getData().get(0);
                eVar3 = this.cbR.cbQ;
                if (eVar3 != null) {
                    eVar4 = this.cbR.cbQ;
                    eVar4.a(false, fVar, false, ahB);
                }
            }
            this.cbR.B(0, ahB);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.f>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.recommendfrs.data.f> writeCacheMessage) {
    }
}
