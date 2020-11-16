package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.u;
import tbclient.GetStoreRemindTime.DataReq;
import tbclient.GetStoreRemindTime.GetStoreRemindTimeReqIdl;
/* loaded from: classes23.dex */
public class GetStoreRemindTimeRequestMessage extends NetMessage {
    public GetStoreRemindTimeRequestMessage() {
        super(1003067, CmdConfigSocket.CMD_GET_STORE_REMIND_TIME);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            u.a(builder, true);
        }
        GetStoreRemindTimeReqIdl.Builder builder2 = new GetStoreRemindTimeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
