package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private long bmk;
    private String bml;
    private double hnW;
    private double hnX;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.bmk = j;
    }

    public void b(double d, double d2) {
        this.hnW = d;
        this.hnX = d2;
    }

    public void Av(String str) {
        this.bml = str;
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
        this.bml = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.bmk > 0) {
            addParam("live_id", this.bmk);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.bml);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.hnW);
        addParam("lat", this.hnX);
    }
}
