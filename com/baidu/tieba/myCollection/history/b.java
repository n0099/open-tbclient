package com.baidu.tieba.myCollection.history;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class b implements a.InterfaceC0052a<com.baidu.tieba.myCollection.baseHistory.b> {
    final /* synthetic */ PbHistoryActivity cce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbHistoryActivity pbHistoryActivity) {
        this.cce = pbHistoryActivity;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.b> readCacheMessage) {
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
            return;
        }
        this.cce.aX(readCacheRespMsg.getData());
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0052a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.b> writeCacheMessage) {
        if (writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
            if (!writeCacheMessage.isClear()) {
                this.cce.Ko();
            } else {
                this.cce.aX(new ArrayList());
            }
        }
    }
}
