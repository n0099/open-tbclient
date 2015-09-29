package com.baidu.tieba.themeCenter.theme.download;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetUpdateInfo.DataReq;
import tbclient.GetUpdateInfo.GetUpdateInfoReqIdl;
/* loaded from: classes.dex */
public class SkinUpdateRequestMessage extends NetMessage {
    public SkinUpdateRequestMessage() {
        super(CmdConfigHttp.CMD_THEME_LIST_UPDATE, 309013);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            com.baidu.tbadk.util.h.a(builder, true);
        }
        GetUpdateInfoReqIdl.Builder builder2 = new GetUpdateInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
