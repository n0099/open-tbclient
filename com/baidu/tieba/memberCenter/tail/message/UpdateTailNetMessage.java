package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.UpdateTail.ReqData;
import tbclient.UpdateTail.UpdateTailReqIdl;
/* loaded from: classes9.dex */
public class UpdateTailNetMessage extends NetMessage {
    ReqData.Builder data;
    UpdateTailReqIdl.Builder idl;

    public UpdateTailNetMessage(int i, String str, String str2, String str3) {
        super(1003023, CmdConfigSocket.CMD_TAIL_UPDATE);
        this.data = new ReqData.Builder();
        this.idl = new UpdateTailReqIdl.Builder();
        this.data.tailId = Integer.valueOf(i);
        this.data.tailContent = str;
        this.data.fontColor = str2;
        this.data.fontKeyName = str3;
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
