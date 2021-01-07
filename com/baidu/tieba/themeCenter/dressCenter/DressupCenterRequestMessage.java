package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetThemeList.DataReq;
import tbclient.GetThemeList.GetThemeListReqIdl;
/* loaded from: classes9.dex */
public class DressupCenterRequestMessage extends NetMessage {
    public DressupCenterRequestMessage() {
        super(1003030, CmdConfigSocket.CMD_DRESSUP_CENTER);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.b(builder, true);
        }
        GetThemeListReqIdl.Builder builder2 = new GetThemeListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
