package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.tbadkCore.util.o;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0055a<com.baidu.tieba.myCollection.baseHistory.b> {
    final /* synthetic */ a dVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.dVV = aVar;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.b> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && (readCacheRespMsg.getData() instanceof List)) {
            o godFeedReadHistory = TbadkCoreApplication.m411getInst().getGodFeedReadHistory();
            for (com.baidu.tieba.myCollection.baseHistory.b bVar : readCacheRespMsg.getData()) {
                if (bVar != null && !StringUtils.isNull(bVar.getThreadId()) && godFeedReadHistory != null) {
                    godFeedReadHistory.a(bVar.getThreadId(), bVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0055a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.b> writeCacheMessage) {
    }
}
