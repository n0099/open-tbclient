package com.baidu.tieba.usermute.request;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.l;
import tbclient.UserMuteCheck.DataReq;
import tbclient.UserMuteCheck.UserMuteCheckReqIdl;
/* loaded from: classes.dex */
public class UserMuteCheckRequestMessage extends NetMessage {
    private long userIdF;
    private long userIdT;

    public void setUserIdF(long j) {
        this.userIdF = j;
    }

    public void setUserIdT(long j) {
        this.userIdT = j;
    }

    public UserMuteCheckRequestMessage() {
        super(CmdConfigHttp.CMD_USER_MUTE_CHECK, 303040);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id_f = Long.valueOf(this.userIdF);
        builder.user_id_t = Long.valueOf(this.userIdT);
        if (z) {
            l.a(builder, true);
        }
        UserMuteCheckReqIdl.Builder builder2 = new UserMuteCheckReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
