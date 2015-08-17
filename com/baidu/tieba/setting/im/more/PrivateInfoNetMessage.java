package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetPrivateInfo.GetPrivateInfoReqIdl;
import tbclient.GetPrivateInfo.ReqData;
/* loaded from: classes.dex */
public class PrivateInfoNetMessage extends NetMessage {
    public PrivateInfoNetMessage() {
        super(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        ReqData.Builder builder = new ReqData.Builder();
        builder.user_id = 100L;
        if (z) {
            com.baidu.tbadk.util.g.a(builder, true);
        }
        GetPrivateInfoReqIdl.Builder builder2 = new GetPrivateInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
