package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private long bnV;
    private String bnW;
    private double hop;
    private double hoq;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.bnV = j;
    }

    public void c(double d, double d2) {
        this.hop = d;
        this.hoq = d2;
    }

    public void Ba(String str) {
        this.bnW = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public a() {
        super(1031023);
        this.roomId = "";
        this.bnW = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.bnV > 0) {
            addParam("live_id", this.bnV);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.bnW);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.hop);
        addParam("lat", this.hoq);
    }
}
