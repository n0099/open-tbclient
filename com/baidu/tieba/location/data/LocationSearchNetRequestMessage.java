package com.baidu.tieba.location.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetSuggestionByAddrName.DataReq;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameReqIdl;
/* loaded from: classes8.dex */
public class LocationSearchNetRequestMessage extends NetMessage {
    private String addrName;

    public LocationSearchNetRequestMessage() {
        super(1003002, CmdConfigSocket.CMD_GET_SUGGESTLOCSTION_BY_NAME);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.addr_name = this.addrName;
        if (z) {
            t.b(builder, true);
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
