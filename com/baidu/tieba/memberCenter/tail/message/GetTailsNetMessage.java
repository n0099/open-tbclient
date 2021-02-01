package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetTails.GetTailsReqIdl;
import tbclient.GetTails.ReqData;
/* loaded from: classes9.dex */
public class GetTailsNetMessage extends NetMessage {
    ReqData.Builder data;
    GetTailsReqIdl.Builder idl;

    public GetTailsNetMessage(String str) {
        super(1003021, CmdConfigSocket.CMD_TAIL_GET);
        this.data = new ReqData.Builder();
        this.idl = new GetTailsReqIdl.Builder();
        this.data.st_type = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        if (z) {
            v.b(this.data, true);
        }
        this.idl.data = this.data.build(false);
        return this.idl.build(false);
    }
}
