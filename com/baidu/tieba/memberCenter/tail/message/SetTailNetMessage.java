package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.SetTail.ReqData;
import tbclient.SetTail.SetTailReqIdl;
/* loaded from: classes8.dex */
public class SetTailNetMessage extends NetMessage {
    ReqData.Builder data;
    SetTailReqIdl.Builder idl;

    public SetTailNetMessage(int i, int i2) {
        super(1003022, CmdConfigSocket.CMD_TAIL_SET);
        this.data = new ReqData.Builder();
        this.idl = new SetTailReqIdl.Builder();
        this.data.tailId = Integer.valueOf(i);
        this.data.type = Integer.valueOf(i2);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        if (z) {
            t.b(this.data, true);
        }
        this.idl.data = this.data.build(false);
        return this.idl.build(false);
    }
}
