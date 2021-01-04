package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.UserMuteQuery.DataReq;
import tbclient.UserMuteQuery.UserMuteQueryReqIdl;
/* loaded from: classes8.dex */
public class UserMuteQueryRequestMessage extends NetMessage {
    private int pn;
    private int rn;
    private long userId;

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public UserMuteQueryRequestMessage() {
        super(1003026, CmdConfigSocket.CMD_USER_MUTE_QUERY);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id = Long.valueOf(this.userId);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            t.b(builder, true);
        }
        UserMuteQueryReqIdl.Builder builder2 = new UserMuteQueryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
