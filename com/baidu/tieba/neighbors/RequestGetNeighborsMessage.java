package com.baidu.tieba.neighbors;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.Person.DataReq;
import tbclient.Person.PersonReqIdl;
/* loaded from: classes.dex */
public class RequestGetNeighborsMessage extends TbSocketMessage {
    private static final int ITEMS_PER_PAGE = 20;
    private int mGeo;
    private double mLat;
    private double mLon;
    private int mOffset;
    private int mSex;

    public RequestGetNeighborsMessage(int i) {
        super(303004);
    }

    public void setParams(String str, String str2, int i, int i2, int i3) {
        this.mGeo = i;
        this.mOffset = i3;
        this.mLat = com.baidu.adp.lib.e.b.a(str, 0.0d);
        this.mLon = com.baidu.adp.lib.e.b.a(str2, 0.0d);
        this.mSex = i2;
        if (this.mSex < 0 || this.mSex > 2) {
            this.mSex = 0;
        }
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    protected Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.lat = Double.valueOf(this.mLat);
        builder.lng = Double.valueOf(this.mLon);
        builder.geo = Integer.valueOf(this.mGeo);
        builder.sex = Integer.valueOf(this.mSex);
        builder.offset = this.mOffset == -1 ? null : Integer.valueOf(this.mOffset);
        builder.rn = 20;
        PersonReqIdl.Builder builder2 = new PersonReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
