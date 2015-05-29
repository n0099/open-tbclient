package com.baidu.tieba.myCollection.history;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.mvc.model.d<com.baidu.tieba.myCollection.baseHistory.b> {
    final /* synthetic */ PbHistoryActivity bHI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbHistoryActivity pbHistoryActivity) {
        this.bHI = pbHistoryActivity;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.b>> readCacheRespMsg, ReadCacheMessage<com.baidu.tieba.myCollection.baseHistory.b> readCacheMessage) {
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
            return;
        }
        this.bHI.aQ(readCacheRespMsg.getData());
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<com.baidu.tieba.myCollection.baseHistory.b>> writeCacheRespMsg, WriteCacheMessage<com.baidu.tieba.myCollection.baseHistory.b> writeCacheMessage) {
        if (writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
            if (!writeCacheMessage.isClear()) {
                this.bHI.WS();
            } else {
                this.bHI.aQ(new ArrayList());
            }
        }
    }
}
