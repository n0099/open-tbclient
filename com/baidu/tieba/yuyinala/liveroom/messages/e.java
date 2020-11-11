package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    private long bnV;
    private String bnW;
    private long mAlaId;
    private long mTime;
    private long nXB;

    public void setFrom(String str) {
        this.bnW = str;
    }

    public void setLiveId(long j) {
        this.bnV = j;
    }

    public void aB(long j) {
        this.mTime = j;
    }

    public void as(long j) {
        this.nXB = j;
    }

    public e() {
        super(1031024);
        this.bnW = "";
        this.bnV = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bnW);
        addParam("live_id", this.bnV);
        addParam("enter_time", this.mTime);
        if (this.nXB > 0) {
            addParam("send_time", this.nXB);
        }
    }
}
