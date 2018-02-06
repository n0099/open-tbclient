package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.UserMuteQuery.DataReq;
import tbclient.UserMuteQuery.UserMuteQueryReqIdl;
/* loaded from: classes3.dex */
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
        super(CmdConfigHttp.CMD_USER_MUTE_QUERY, 303028);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id = Long.valueOf(this.userId);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            o.bindCommonParamsToProtobufData(builder, true);
        }
        UserMuteQueryReqIdl.Builder builder2 = new UserMuteQueryReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
