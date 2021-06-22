package com.baidu.tieba.write.write.message;

import GetSticker.DataReq;
import GetSticker.GetStickerReqIdl;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.CommonReq;
/* loaded from: classes5.dex */
public class RequestGetStickerMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f22306common;

    public RequestGetStickerMessage() {
        super(CmdConfigHttp.CMD_GET_STICKET_LIST, 309475);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f993common = this.f22306common;
        if (z) {
            w.a(builder, true);
        }
        GetStickerReqIdl.Builder builder2 = new GetStickerReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setCommon(CommonReq commonReq) {
        this.f22306common = commonReq;
    }
}
