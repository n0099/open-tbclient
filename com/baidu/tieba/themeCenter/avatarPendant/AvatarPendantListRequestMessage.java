package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.GetPendantByCategory.DataReq;
import tbclient.GetPendantByCategory.GetPendantByCategoryReqIdl;
/* loaded from: classes5.dex */
public class AvatarPendantListRequestMessage extends NetMessage {
    public AvatarPendantListRequestMessage() {
        super(CmdConfigHttp.CMD_AVATAR_PENDANT_LIST, 309371);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetPendantByCategoryReqIdl.Builder builder2 = new GetPendantByCategoryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
