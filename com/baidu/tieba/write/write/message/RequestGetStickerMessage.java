package com.baidu.tieba.write.write.message;

import GetSticker.DataReq;
import GetSticker.GetStickerReqIdl;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.CommonReq;
/* loaded from: classes3.dex */
public class RequestGetStickerMessage extends NetMessage {
    private CommonReq common;

    public RequestGetStickerMessage() {
        super(CmdConfigHttp.CMD_GET_STICKET_LIST, 309475);
    }

    public void setCommon(CommonReq commonReq) {
        this.common = commonReq;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.common = this.common;
        if (z) {
            r.bindCommonParamsToProtobufData(builder, true);
        }
        GetStickerReqIdl.Builder builder2 = new GetStickerReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
