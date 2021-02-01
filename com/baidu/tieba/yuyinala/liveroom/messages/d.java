package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class d extends HttpMessage {
    private long liveId;

    public d() {
        super(1031048);
        this.liveId = 0L;
    }

    public void setLiveId(long j) {
        this.liveId = j;
    }

    public void setParams() {
        addParam("live_id", this.liveId);
    }
}
