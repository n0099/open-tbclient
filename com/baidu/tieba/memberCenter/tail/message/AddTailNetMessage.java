package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.AddTail.AddTailReqIdl;
import tbclient.AddTail.ReqData;
/* loaded from: classes8.dex */
public class AddTailNetMessage extends NetMessage {
    ReqData.Builder data;

    public AddTailNetMessage(String str, String str2, String str3) {
        super(1003019, CmdConfigSocket.CMD_TAIL_ADD);
        this.data = new ReqData.Builder();
        this.data.tailContent = str;
        this.data.fontColor = str2;
        this.data.fontKeyName = str3;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        AddTailReqIdl.Builder builder = new AddTailReqIdl.Builder();
        if (z) {
            v.b(this.data, true);
        }
        builder.data = this.data.build(false);
        return builder.build(false);
    }
}
