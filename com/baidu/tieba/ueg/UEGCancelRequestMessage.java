package com.baidu.tieba.ueg;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.b.e.m.b;
import d.b.h0.z0.w;
import tbclient.QueryBlockAndAppealInfo.DataReq;
import tbclient.QueryBlockAndAppealInfo.QueryBlockAndAppealInfoReqIdl;
/* loaded from: classes5.dex */
public class UEGCancelRequestMessage extends NetMessage {
    public String uId;

    public UEGCancelRequestMessage() {
        super(CmdConfigHttp.CMD_UEG_CANCEL, 309615);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id = Long.valueOf(b.f(this.uId, 0L));
        if (z) {
            w.a(builder, true);
        }
        QueryBlockAndAppealInfoReqIdl.Builder builder2 = new QueryBlockAndAppealInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getUser_id() {
        return this.uId;
    }

    public void setUser_id(String str) {
        this.uId = str;
    }
}
