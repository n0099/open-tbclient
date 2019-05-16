package com.baidu.tieba.ueg;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.s;
import tbclient.QueryBlockAndAppealInfo.DataReq;
import tbclient.QueryBlockAndAppealInfo.QueryBlockAndAppealInfoReqIdl;
/* loaded from: classes.dex */
public class UEGCancelRequestMessage extends NetMessage {
    private String uId;

    public String getUser_id() {
        return this.uId;
    }

    public void setUser_id(String str) {
        this.uId = str;
    }

    public UEGCancelRequestMessage() {
        super(CmdConfigHttp.CMD_UEG_CANCEL, 309615);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.user_id = Long.valueOf(com.baidu.adp.lib.g.b.c(this.uId, 0L));
        if (z) {
            s.bindCommonParamsToProtobufData(builder, true);
        }
        QueryBlockAndAppealInfoReqIdl.Builder builder2 = new QueryBlockAndAppealInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
