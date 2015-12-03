package com.baidu.tieba.myCollection.history;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class b implements a.InterfaceC0054a<com.baidu.tieba.myCollection.baseHistory.b> {
    final /* synthetic */ PbHistoryActivity cuS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbHistoryActivity pbHistoryActivity) {
        this.cuS = pbHistoryActivity;
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.b> readCacheMessage) {
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
            return;
        }
        this.cuS.bm(readCacheRespMsg.getData());
    }

    @Override // com.baidu.tbadk.mvc.model.a.InterfaceC0054a
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.b> writeCacheMessage) {
        if (writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
            if (!writeCacheMessage.isClear()) {
                this.cuS.LV();
            } else {
                this.cuS.bm(new ArrayList());
            }
        }
    }
}
