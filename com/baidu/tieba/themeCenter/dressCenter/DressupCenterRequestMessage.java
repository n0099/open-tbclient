package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.i0.z0.w;
import tbclient.GetThemeList.DataReq;
import tbclient.GetThemeList.GetThemeListReqIdl;
/* loaded from: classes5.dex */
public class DressupCenterRequestMessage extends NetMessage {
    public DressupCenterRequestMessage() {
        super(CmdConfigHttp.CMD_DRESSUP_CENTER, 309001);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetThemeListReqIdl.Builder builder2 = new GetThemeListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
