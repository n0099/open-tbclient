package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class e extends HttpMessage {
    private long bvY;
    private String bvZ;
    private long mAlaId;
    private long mTime;
    private long orv;

    public void setFrom(String str) {
        this.bvZ = str;
    }

    public void setLiveId(long j) {
        this.bvY = j;
    }

    public void aZ(long j) {
        this.mTime = j;
    }

    public void aP(long j) {
        this.orv = j;
    }

    public e() {
        super(1031024);
        this.bvZ = "";
        this.bvY = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bvZ);
        addParam("live_id", this.bvY);
        addParam("enter_time", this.mTime);
        if (this.orv > 0) {
            addParam("send_time", this.orv);
        }
    }
}
