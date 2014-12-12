package com.baidu.tieba.tbadkCore.location;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.GetSuggestionByAddrName.DataReq;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameReqIdl;
/* loaded from: classes.dex */
public class LocationSearchRequestMessage extends TbSocketMessage {
    private String addressName;

    public LocationSearchRequestMessage() {
        super(303018);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.addr_name = this.addressName;
        GetSuggestionByAddrNameReqIdl.Builder builder2 = new GetSuggestionByAddrNameReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getAddressName() {
        return this.addressName;
    }

    public void setAddressName(String str) {
        this.addressName = str;
    }
}
