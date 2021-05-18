package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.UserMuteQuery.DataReq;
import tbclient.UserMuteQuery.UserMuteQueryReqIdl;
/* loaded from: classes5.dex */
public class UserMuteQueryRequestMessage extends NetMessage {
    public int pn;
    public int rn;
    public long userId;

    public UserMuteQueryRequestMessage() {
        super(CmdConfigHttp.CMD_USER_MUTE_QUERY, 303028);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id = Long.valueOf(this.userId);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            w.a(builder, true);
        }
        UserMuteQueryReqIdl.Builder builder2 = new UserMuteQueryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setRn(int i2) {
        this.rn = i2;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
