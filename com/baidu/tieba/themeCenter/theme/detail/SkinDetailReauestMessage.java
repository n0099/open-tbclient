package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetSkin.DataReq;
import tbclient.GetSkin.GetSkinReqIdl;
/* loaded from: classes.dex */
public class SkinDetailReauestMessage extends NetMessage {
    private int themeId;

    public SkinDetailReauestMessage() {
        super(CmdConfigHttp.CMD_SKIN_DETAIL, 309012);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Integer.valueOf(this.themeId);
        if (z) {
            com.baidu.tbadk.util.h.a(builder, true);
        }
        GetSkinReqIdl.Builder builder2 = new GetSkinReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getThemeId() {
        return this.themeId;
    }

    public void setThemeId(int i) {
        this.themeId = i;
    }
}
