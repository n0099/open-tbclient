package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class e extends HttpMessage {
    private long buN;
    private String buO;
    private long mAlaId;
    private long mTime;
    private long oxg;

    public void setFrom(String str) {
        this.buO = str;
    }

    public void setLiveId(long j) {
        this.buN = j;
    }

    public void bd(long j) {
        this.mTime = j;
    }

    public void aS(long j) {
        this.oxg = j;
    }

    public e() {
        super(1031024);
        this.buO = "";
        this.buN = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.buO);
        addParam("live_id", this.buN);
        addParam("enter_time", this.mTime);
        if (this.oxg > 0) {
            addParam("send_time", this.oxg);
        }
    }
}
