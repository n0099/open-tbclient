package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.AddTail.AddTailReqIdl;
import tbclient.AddTail.ReqData;
/* loaded from: classes3.dex */
public class AddTailNetMessage extends NetMessage {
    public ReqData.Builder data;

    public AddTailNetMessage(String str, String str2, String str3) {
        super(CmdConfigHttp.CMD_TAIL_ADD, 305101);
        ReqData.Builder builder = new ReqData.Builder();
        this.data = builder;
        builder.tailContent = str;
        builder.fontColor = str2;
        builder.fontKeyName = str3;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        AddTailReqIdl.Builder builder = new AddTailReqIdl.Builder();
        if (z) {
            w.a(this.data, true);
        }
        builder.data = this.data.build(false);
        return builder.build(false);
    }
}
