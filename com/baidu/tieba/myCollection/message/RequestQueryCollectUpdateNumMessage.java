package com.baidu.tieba.myCollection.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.QueryCollectUpdateNum.DataReq;
import tbclient.QueryCollectUpdateNum.QueryCollectUpdateNumReqIdl;
/* loaded from: classes6.dex */
public class RequestQueryCollectUpdateNumMessage extends TbSocketMessage {
    public RequestQueryCollectUpdateNumMessage() {
        super(303005);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.collect_mark = 1;
        QueryCollectUpdateNumReqIdl.Builder builder2 = new QueryCollectUpdateNumReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
