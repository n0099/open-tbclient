package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetStoreRemindTime.DataReq;
import tbclient.GetStoreRemindTime.GetStoreRemindTimeReqIdl;
/* loaded from: classes5.dex */
public class GetStoreRemindTimeRequestMessage extends NetMessage {
    public GetStoreRemindTimeRequestMessage() {
        super(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, 309117);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetStoreRemindTimeReqIdl.Builder builder2 = new GetStoreRemindTimeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
