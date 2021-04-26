package com.baidu.tieba.location.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.i0.z0.w;
import tbclient.GetSuggestionByAddrName.DataReq;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameReqIdl;
/* loaded from: classes3.dex */
public class LocationSearchNetRequestMessage extends NetMessage {
    public String addrName;

    public LocationSearchNetRequestMessage() {
        super(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.addr_name = this.addrName;
        if (z) {
            w.a(builder, true);
        }
        GetSuggestionByAddrNameReqIdl.Builder builder2 = new GetSuggestionByAddrNameReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getAddrName() {
        return this.addrName;
    }

    public void setAddrName(String str) {
        this.addrName = str;
    }
}
