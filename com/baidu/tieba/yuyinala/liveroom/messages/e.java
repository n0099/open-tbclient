package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    private long bmk;
    private String bml;
    private long mAlaId;
    private long mTime;
    private long nZe;

    public void setFrom(String str) {
        this.bml = str;
    }

    public void setLiveId(long j) {
        this.bmk = j;
    }

    public void aB(long j) {
        this.mTime = j;
    }

    public void as(long j) {
        this.nZe = j;
    }

    public e() {
        super(1031024);
        this.bml = "";
        this.bmk = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bml);
        addParam("live_id", this.bmk);
        addParam("enter_time", this.mTime);
        if (this.nZe > 0) {
            addParam("send_time", this.nZe);
        }
    }
}
