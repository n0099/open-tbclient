package com.baidu.tieba.memberCenter.tail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.GetTails.GetTailsReqIdl;
import tbclient.GetTails.ReqData;
/* loaded from: classes3.dex */
public class GetTailsNetMessage extends NetMessage {
    public ReqData.Builder data;
    public GetTailsReqIdl.Builder idl;

    public GetTailsNetMessage(String str) {
        super(CmdConfigHttp.CMD_TAIL_GET, 305001);
        this.data = new ReqData.Builder();
        this.idl = new GetTailsReqIdl.Builder();
        this.data.st_type = str;
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
