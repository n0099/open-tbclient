package com.baidu.tieba.themeCenter.theme.top;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetSkinByCategory.DataReq;
import tbclient.GetSkinByCategory.GetSkinByCategoryReqIdl;
/* loaded from: classes.dex */
public class TopThemeListRequestMessage extends NetMessage {
    public TopThemeListRequestMessage() {
        super(CmdConfigHttp.CMD_TOP_THEME_LIST, 309010);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            com.baidu.tbadk.util.h.a(builder, true);
        }
        GetSkinByCategoryReqIdl.Builder builder2 = new GetSkinByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
