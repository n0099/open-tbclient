package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class e extends HttpMessage {
    private long bwn;
    private String bwo;
    private long mAlaId;
    private long mTime;
    private long ozl;

    public void setFrom(String str) {
        this.bwo = str;
    }

    public void setLiveId(long j) {
        this.bwn = j;
    }

    public void bd(long j) {
        this.mTime = j;
    }

    public void aS(long j) {
        this.ozl = j;
    }

    public e() {
        super(1031024);
        this.bwo = "";
        this.bwn = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bwo);
        addParam("live_id", this.bwn);
        addParam("enter_time", this.mTime);
        if (this.ozl > 0) {
            addParam("send_time", this.ozl);
        }
    }
}
