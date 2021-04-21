package com.baidu.tieba.userblock.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.GetUserBlackInfo.DataReq;
import tbclient.GetUserBlackInfo.GetUserBlackInfoReqIdl;
/* loaded from: classes5.dex */
public class UserBlockInfoRequestMessage extends NetMessage {
    public long mBlockUserId;

    public UserBlockInfoRequestMessage() {
        super(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, 309698);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.black_uid = Long.valueOf(this.mBlockUserId);
        if (z) {
            w.a(builder, true);
        }
        GetUserBlackInfoReqIdl.Builder builder2 = new GetUserBlackInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getBlockUserId() {
        return this.mBlockUserId;
    }

    public void setBlockUserId(long j) {
        this.mBlockUserId = j;
    }
}
