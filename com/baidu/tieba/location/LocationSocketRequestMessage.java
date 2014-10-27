package com.baidu.tieba.location;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.GetPoisByLocation.DataReq;
import tbclient.GetPoisByLocation.GetPoisByLocationReqIdl;
/* loaded from: classes.dex */
public class LocationSocketRequestMessage extends TbSocketMessage {
    private String lat;
    private String lng;

    public LocationSocketRequestMessage() {
        super(303017);
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.lat = this.lat;
        builder.lng = this.lng;
        GetPoisByLocationReqIdl.Builder builder2 = new GetPoisByLocationReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
