package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetVipInfo.DataReq;
import tbclient.GetVipInfo.GetVipInfoReqIdl;
/* loaded from: classes8.dex */
public class MembercenterRequestMessage extends NetMessage {
    public MembercenterRequestMessage() {
        super(1003048, CmdConfigSocket.CMD_MEMBERCENTER_INDEX);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.b(builder, true);
        }
        GetVipInfoReqIdl.Builder builder2 = new GetVipInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
