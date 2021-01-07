package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetBgByCategory.DataReq;
import tbclient.GetBgByCategory.GetBgByCategoryReqIdl;
/* loaded from: classes9.dex */
public class BackgroundGroupRequestMessage extends NetMessage {
    public BackgroundGroupRequestMessage() {
        super(1003033, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_GROUP);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.b(builder, true);
        }
        GetBgByCategoryReqIdl.Builder builder2 = new GetBgByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
