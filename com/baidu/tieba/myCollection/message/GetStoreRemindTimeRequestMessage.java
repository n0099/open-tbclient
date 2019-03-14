package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.s;
import tbclient.GetStoreRemindTime.DataReq;
import tbclient.GetStoreRemindTime.GetStoreRemindTimeReqIdl;
/* loaded from: classes6.dex */
public class GetStoreRemindTimeRequestMessage extends NetMessage {
    public GetStoreRemindTimeRequestMessage() {
        super(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, 309117);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            s.bindCommonParamsToProtobufData(builder, true);
        }
        GetStoreRemindTimeReqIdl.Builder builder2 = new GetStoreRemindTimeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
