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
    final /* synthetic */ b cIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cIh = bVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<g>> readCacheRespMsg, ReadCacheMessage<g> readCacheMessage) {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        b.a aVar4;
        String aqi = (readCacheMessage == null || readCacheMessage.getRequestData() == null || !(readCacheMessage.getRequestData() instanceof f)) ? null : ((f) readCacheMessage.getRequestData()).aqi();
        if (aqi != null) {
            if (readCacheRespMsg == null || readCacheRespMsg.getData() == null || readCacheRespMsg.getData().size() <= 0 || readCacheRespMsg.getData().get(0) == null) {
                aVar = this.cIh.cIg;
                if (aVar != null) {
                    aVar2 = this.cIh.cIg;
                    aVar2.a(false, null, false, aqi);
                }
            } else {
                g gVar = readCacheRespMsg.getData().get(0);
                aVar3 = this.cIh.cIg;
                if (aVar3 != null) {
                    aVar4 = this.cIh.cIg;
                    aVar4.a(false, gVar, false, aqi);
                }
            }
            this.cIh.c(0, aqi, 0);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<g>> writeCacheRespMsg, WriteCacheMessage<g> writeCacheMessage) {
    }
}
