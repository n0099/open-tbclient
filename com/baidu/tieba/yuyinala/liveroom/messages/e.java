package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    private long brr;
    private String brs;
    private long mAlaId;
    private long mTime;
    private long oog;

    public void setFrom(String str) {
        this.brs = str;
    }

    public void setLiveId(long j) {
        this.brr = j;
    }

    public void aZ(long j) {
        this.mTime = j;
    }

    public void aQ(long j) {
        this.oog = j;
    }

    public e() {
        super(1031024);
        this.brs = "";
        this.brr = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.brs);
        addParam("live_id", this.brr);
        addParam("enter_time", this.mTime);
        if (this.oog > 0) {
            addParam("send_time", this.oog);
        }
    }
}
