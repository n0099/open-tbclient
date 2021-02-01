package com.baidu.tieba.setting.officialAccountPush;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.v;
import tbclient.GetOfficialSwitch.DataReq;
import tbclient.GetOfficialSwitch.GetOfficialSwitchReqIdl;
/* loaded from: classes8.dex */
public class OfficialAccountPushRequestMessage extends NetMessage {
    public OfficialAccountPushRequestMessage() {
        super(CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, 309620);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            v.b(builder, true);
        }
        GetOfficialSwitchReqIdl.Builder builder2 = new GetOfficialSwitchReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
