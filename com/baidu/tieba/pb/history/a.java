package com.baidu.tieba.pb.history;

import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.data.ai;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.mvc.model.d<ai> {
    final /* synthetic */ PbHistoryActivity bul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbHistoryActivity pbHistoryActivity) {
        this.bul = pbHistoryActivity;
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(ReadCacheRespMsg<List<ai>> readCacheRespMsg, ReadCacheMessage<ai> readCacheMessage) {
        if (readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
            return;
        }
        this.bul.ah(readCacheRespMsg.getData());
    }

    @Override // com.baidu.tbadk.mvc.model.d
    public void a(WriteCacheRespMsg<List<ai>> writeCacheRespMsg, WriteCacheMessage<ai> writeCacheMessage) {
        if (writeCacheRespMsg != null && writeCacheRespMsg.isSuccess()) {
            if (!writeCacheMessage.isClear()) {
                this.bul.VX();
            } else {
                this.bul.ah(new ArrayList());
            }
        }
    }
}
