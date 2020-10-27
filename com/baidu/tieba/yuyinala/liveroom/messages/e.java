package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    private long bmB;
    private String bmC;
    private long mAlaId;
    private long mTime;
    private long nQs;

    public void setFrom(String str) {
        this.bmC = str;
    }

    public void setLiveId(long j) {
        this.bmB = j;
    }

    public void ap(long j) {
        this.mTime = j;
    }

    public void ag(long j) {
        this.nQs = j;
    }

    public e() {
        super(1031024);
        this.bmC = "";
        this.bmB = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bmC);
        addParam("live_id", this.bmB);
        addParam("enter_time", this.mTime);
        if (this.nQs > 0) {
            addParam("send_time", this.nQs);
        }
    }
}
