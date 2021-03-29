package com.baidu.tieba.imMessageCenter;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryUserInfos.DataReq;
import protobuf.QueryUserInfos.QueryUserInfosReqIdl;
/* loaded from: classes3.dex */
public class RequestQueryUserInfoMessage extends TbSocketMessage {
    public DataReq.Builder dataBuilder;

    public RequestQueryUserInfoMessage() {
        super(205003);
        this.dataBuilder = new DataReq.Builder();
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            QueryUserInfosReqIdl.Builder builder = new QueryUserInfosReqIdl.Builder();
            builder.data = this.dataBuilder.build(false);
            return builder.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setReqUserId(long j) {
        this.dataBuilder.reqUserId = Long.valueOf(j);
    }
}
