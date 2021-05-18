package com.baidu.tieba.usermute;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.UserMuteCheck.DataReq;
import tbclient.UserMuteCheck.UserMuteCheckReqIdl;
/* loaded from: classes5.dex */
public class UserMuteCheckRequestMessage extends NetMessage {
    public BdUniqueId mTagId;
    public long userIdF;
    public long userIdT;

    public UserMuteCheckRequestMessage() {
        super(CmdConfigHttp.CMD_USER_MUTE_CHECK, 303040);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id_f = Long.valueOf(this.userIdF);
        builder.user_id_t = Long.valueOf(this.userIdT);
        if (z) {
            w.a(builder, true);
        }
        UserMuteCheckReqIdl.Builder builder2 = new UserMuteCheckReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setUserIdF(long j) {
        this.userIdF = j;
    }

    public void setUserIdT(long j) {
        this.userIdT = j;
    }
}
