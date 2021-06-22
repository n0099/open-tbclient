package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetVipInfo.DataReq;
import tbclient.GetVipInfo.GetVipInfoReqIdl;
/* loaded from: classes4.dex */
public class MembercenterRequestMessage extends NetMessage {
    public MembercenterRequestMessage() {
        super(CmdConfigHttp.CMD_MEMBERCENTER_INDEX, 309062);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetVipInfoReqIdl.Builder builder2 = new GetVipInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
