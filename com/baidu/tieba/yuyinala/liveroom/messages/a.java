package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private double aXv;
    private double aXw;
    private long buN;
    private String buO;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.buN = j;
    }

    public void b(double d, double d2) {
        this.aXv = d;
        this.aXw = d2;
    }

    public void Ag(String str) {
        this.buO = str;
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
        this.buO = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.buN > 0) {
            addParam("live_id", this.buN);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.buO);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.aXv);
        addParam("lat", this.aXw);
    }
}
