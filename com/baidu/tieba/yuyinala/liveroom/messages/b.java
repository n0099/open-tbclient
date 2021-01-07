package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    private long bvY;

    public void setLiveId(long j) {
        this.bvY = j;
    }

    public long edf() {
        return this.bvY;
    }

    public b() {
        super(1031042);
    }

    public void setParams() {
        addParam("live_id", this.bvY);
    }
}
