package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetSuggestionByAddrName.DataReq;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameReqIdl;
/* loaded from: classes.dex */
public class LocationSearchNetRequestMessage extends NetMessage {
    private String addrName;

    public LocationSearchNetRequestMessage() {
        super(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME, 303018);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.addr_name = this.addrName;
        if (z) {
            com.baidu.tbadk.util.h.a(builder, true);
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
