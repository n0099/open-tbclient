package com.baidu.tieba.imMessageCenter;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryUserInfos.DataReq;
import protobuf.QueryUserInfos.QueryUserInfosReqIdl;
/* loaded from: classes7.dex */
public class RequestQueryUserInfoMessage extends TbSocketMessage {
    DataReq.Builder dataBuilder;

    public RequestQueryUserInfoMessage() {
        super(CmdConfigSocket.CMD_QUERY_USER_INFO);
        this.dataBuilder = new DataReq.Builder();
    }

    public void setReqUserId(long j) {
        this.dataBuilder.reqUserId = Long.valueOf(j);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            QueryUserInfosReqIdl.Builder builder = new QueryUserInfosReqIdl.Builder();
            builder.data = this.dataBuilder.build(false);
            return builder.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
