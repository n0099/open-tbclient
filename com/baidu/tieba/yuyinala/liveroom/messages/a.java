package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private double aYV;
    private double aYW;
    private long bwn;
    private String bwo;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.bwn = j;
    }

    public void b(double d, double d2) {
        this.aYV = d;
        this.aYW = d2;
    }

    public void An(String str) {
        this.bwo = str;
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
        this.bwo = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.bwn > 0) {
            addParam("live_id", this.bwn);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.bwo);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.aYV);
        addParam("lat", this.aYW);
    }
}
