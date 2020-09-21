package com.baidu.tieba.setting.im.more;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.u;
import tbclient.GetPrivateInfo.GetPrivateInfoReqIdl;
import tbclient.GetPrivateInfo.ReqData;
/* loaded from: classes.dex */
public class PrivateInfoNetMessage extends NetMessage {
    public PrivateInfoNetMessage() {
        super(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        ReqData.Builder builder = new ReqData.Builder();
        builder.user_id = Long.valueOf(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        if (z) {
            u.a(builder, true);
        }
        GetPrivateInfoReqIdl.Builder builder2 = new GetPrivateInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
