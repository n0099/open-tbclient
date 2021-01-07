package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private double aZd;
    private double aZe;
    private long bvY;
    private String bvZ;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.bvY = j;
    }

    public void b(double d, double d2) {
        this.aZd = d;
        this.aZe = d2;
    }

    public void Ba(String str) {
        this.bvZ = str;
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
        this.bvZ = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.bvY > 0) {
            addParam("live_id", this.bvY);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.bvZ);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.aZd);
        addParam("lat", this.aZe);
    }
}
