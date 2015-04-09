package com.baidu.tieba.recommendfrs.a;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.model.d<com.baidu.tieba.recommendfrs.data.c> {
    final /* synthetic */ b bYj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bYj = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.c>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.recommendfrs.data.c> readCacheMessage) {
        e eVar;
        e eVar2;
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0 && readCacheRespMsg.getData().get(0) != null) {
            com.baidu.tieba.recommendfrs.data.c cVar = readCacheRespMsg.getData().get(0);
            eVar = this.bYj.bYi;
            if (eVar != null) {
                eVar2 = this.bYj.bYi;
                eVar2.a(false, cVar, false);
            }
        }
        this.bYj.hP(0);
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.recommendfrs.data.c>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.recommendfrs.data.c> writeCacheMessage) {
    }
}
