package com.baidu.tieba.write.write.message;

import GetSticker.DataReq;
import GetSticker.GetStickerReqIdl;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.CommonReq;
/* loaded from: classes7.dex */
public class RequestGetStickerMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f3602common;

    public RequestGetStickerMessage() {
        super(1003341, CmdConfigSocket.CMD_GET_STICKET_LIST);
    }

    public void setCommon(CommonReq commonReq) {
        this.f3602common = commonReq;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f946common = this.f3602common;
        if (z) {
            v.b(builder, true);
        }
        GetStickerReqIdl.Builder builder2 = new GetStickerReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
