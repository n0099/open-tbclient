package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.DeleteTail.DeleteTailReqIdl;
import tbclient.DeleteTail.ReqData;
/* loaded from: classes9.dex */
public class DeleteTailNetMessage extends NetMessage {
    ReqData.Builder data;

    public DeleteTailNetMessage(int i) {
        super(1003020, CmdConfigSocket.CMD_TAIL_DELETE);
        this.data = new ReqData.Builder();
        this.data.tailId = Integer.valueOf(i);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DeleteTailReqIdl.Builder builder = new DeleteTailReqIdl.Builder();
        if (z) {
            t.b(this.data, true);
        }
        builder.data = this.data.build(false);
        return builder.build(false);
    }
}
