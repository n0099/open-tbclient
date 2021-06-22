package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.SetTail.ReqData;
import tbclient.SetTail.SetTailReqIdl;
/* loaded from: classes4.dex */
public class SetTailNetMessage extends NetMessage {
    public ReqData.Builder data;
    public SetTailReqIdl.Builder idl;

    public SetTailNetMessage(int i2, int i3) {
        super(CmdConfigHttp.CMD_TAIL_SET, 305104);
        this.data = new ReqData.Builder();
        this.idl = new SetTailReqIdl.Builder();
        this.data.tailId = Integer.valueOf(i2);
        this.data.type = Integer.valueOf(i3);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        if (z) {
            w.a(this.data, true);
        }
        this.idl.data = this.data.build(false);
        return this.idl.build(false);
    }
}
