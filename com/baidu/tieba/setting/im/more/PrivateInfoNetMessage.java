package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.e.m.b;
import d.a.n0.z0.w;
import tbclient.GetPrivateInfo.GetPrivateInfoReqIdl;
import tbclient.GetPrivateInfo.ReqData;
/* loaded from: classes5.dex */
public class PrivateInfoNetMessage extends NetMessage {
    public PrivateInfoNetMessage() {
        super(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        ReqData.Builder builder = new ReqData.Builder();
        builder.user_id = Long.valueOf(b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
        if (z) {
            w.a(builder, true);
        }
        GetPrivateInfoReqIdl.Builder builder2 = new GetPrivateInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
