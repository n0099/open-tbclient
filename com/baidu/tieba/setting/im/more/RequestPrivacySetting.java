package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import protobuf.GetPrivateInfo.GetPrivateInfoReqIdl;
import protobuf.GetPrivateInfo.ReqData;
/* loaded from: classes.dex */
public class RequestPrivacySetting extends NetMessage {
    public RequestPrivacySetting() {
        super(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        GetPrivateInfoReqIdl.Builder builder = new GetPrivateInfoReqIdl.Builder();
        ReqData.Builder builder2 = new ReqData.Builder();
        builder2.user_id = 100L;
        builder.data = builder2.build(true);
        return builder.build(false);
    }
}
