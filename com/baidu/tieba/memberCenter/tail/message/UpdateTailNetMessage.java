package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.i0.z0.w;
import tbclient.UpdateTail.ReqData;
import tbclient.UpdateTail.UpdateTailReqIdl;
/* loaded from: classes3.dex */
public class UpdateTailNetMessage extends NetMessage {
    public ReqData.Builder data;
    public UpdateTailReqIdl.Builder idl;

    public UpdateTailNetMessage(int i2, String str, String str2, String str3) {
        super(CmdConfigHttp.CMD_TAIL_UPDATE, 305102);
        this.data = new ReqData.Builder();
        this.idl = new UpdateTailReqIdl.Builder();
        this.data.tailId = Integer.valueOf(i2);
        ReqData.Builder builder = this.data;
        builder.tailContent = str;
        builder.fontColor = str2;
        builder.fontKeyName = str3;
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
