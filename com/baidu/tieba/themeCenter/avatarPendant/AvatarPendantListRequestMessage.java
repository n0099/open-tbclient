package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetPendantByCategory.DataReq;
import tbclient.GetPendantByCategory.GetPendantByCategoryReqIdl;
/* loaded from: classes8.dex */
public class AvatarPendantListRequestMessage extends NetMessage {
    public AvatarPendantListRequestMessage() {
        super(1003178, CmdConfigSocket.CMD_AVATAR_APENDANT);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            v.b(builder, true);
        }
        GetPendantByCategoryReqIdl.Builder builder2 = new GetPendantByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
