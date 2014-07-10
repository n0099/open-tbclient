package com.baidu.tieba.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.FriendFeedPage.DataReq;
import tbclient.FriendFeedPage.FriendFeedPageReqIdl;
/* loaded from: classes.dex */
public class RequestFriendFeedMessage extends TbSocketMessage {
    private int limit;
    private int qType;
    private double scrDip;
    private int scrH;
    private int scrW;
    private String timeline;

    public RequestFriendFeedMessage() {
        super(303003);
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public String getTimeline() {
        return this.timeline;
    }

    public void setTimeline(String str) {
        this.timeline = str;
    }

    public int getScrW() {
        return this.scrW;
    }

    public void setScrW(int i) {
        this.scrW = i;
    }

    public int getScrH() {
        return this.scrH;
    }

    public void setScrH(int i) {
        this.scrH = i;
    }

    public double getScrDip() {
        return this.scrDip;
    }

    public void setScrDip(double d) {
        this.scrDip = d;
    }

    public int getqType() {
        return this.qType;
    }

    public void setqType(int i) {
        this.qType = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.limit = Integer.valueOf(getLimit());
        builder.timeline = getTimeline();
        builder.scr_h = Integer.valueOf(getScrH());
        builder.scr_w = Integer.valueOf(getScrW());
        builder.scr_dip = Double.valueOf(getScrDip());
        builder.q_type = Integer.valueOf(getqType());
        FriendFeedPageReqIdl.Builder builder2 = new FriendFeedPageReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
