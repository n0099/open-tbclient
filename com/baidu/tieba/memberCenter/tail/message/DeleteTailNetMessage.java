package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.DeleteTail.DeleteTailReqIdl;
import tbclient.DeleteTail.ReqData;
/* loaded from: classes3.dex */
public class DeleteTailNetMessage extends NetMessage {
    public ReqData.Builder data;

    public DeleteTailNetMessage(int i) {
        super(CmdConfigHttp.CMD_TAIL_DELETE, 305103);
        ReqData.Builder builder = new ReqData.Builder();
        this.data = builder;
        builder.tailId = Integer.valueOf(i);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DeleteTailReqIdl.Builder builder = new DeleteTailReqIdl.Builder();
        if (z) {
            w.a(this.data, true);
        }
        builder.data = this.data.build(false);
        return builder.build(false);
    }
}
