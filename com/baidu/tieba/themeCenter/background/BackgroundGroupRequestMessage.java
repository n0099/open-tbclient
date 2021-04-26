package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.i0.z0.w;
import tbclient.GetBgByCategory.DataReq;
import tbclient.GetBgByCategory.GetBgByCategoryReqIdl;
/* loaded from: classes5.dex */
public class BackgroundGroupRequestMessage extends NetMessage {
    public BackgroundGroupRequestMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, 309020);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetBgByCategoryReqIdl.Builder builder2 = new GetBgByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
