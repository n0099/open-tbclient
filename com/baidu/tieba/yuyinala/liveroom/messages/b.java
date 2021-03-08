package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    private long bwn;

    public void setLiveId(long j) {
        this.bwn = j;
    }

    public long ebP() {
        return this.bwn;
    }

    public b() {
        super(1031042);
    }

    public void setParams() {
        addParam("live_id", this.bwn);
    }
}
