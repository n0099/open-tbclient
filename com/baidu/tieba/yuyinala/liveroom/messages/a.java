package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private double aXy;
    private double aXz;
    private long brr;
    private String brs;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.brr = j;
    }

    public void b(double d, double d2) {
        this.aXy = d;
        this.aXz = d2;
    }

    public void Bc(String str) {
        this.brs = str;
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
        this.brs = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.brr > 0) {
            addParam("live_id", this.brr);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.brs);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.aXy);
        addParam("lat", this.aXz);
    }
}
