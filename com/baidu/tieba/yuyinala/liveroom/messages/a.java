package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private long bmB;
    private String bmC;
    private double hiy;
    private double hiz;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.bmB = j;
    }

    public void c(double d, double d2) {
        this.hiy = d;
        this.hiz = d2;
    }

    public void AM(String str) {
        this.bmC = str;
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
        this.bmC = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.bmB > 0) {
            addParam("live_id", this.bmB);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.bmC);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.hiy);
        addParam("lat", this.hiz);
    }
}
