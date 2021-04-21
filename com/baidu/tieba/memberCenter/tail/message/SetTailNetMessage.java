package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.SetTail.ReqData;
import tbclient.SetTail.SetTailReqIdl;
/* loaded from: classes3.dex */
public class SetTailNetMessage extends NetMessage {
    public ReqData.Builder data;
    public SetTailReqIdl.Builder idl;

    public SetTailNetMessage(int i, int i2) {
        super(CmdConfigHttp.CMD_TAIL_SET, 305104);
        this.data = new ReqData.Builder();
        this.idl = new SetTailReqIdl.Builder();
        this.data.tailId = Integer.valueOf(i);
        this.data.type = Integer.valueOf(i2);
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
