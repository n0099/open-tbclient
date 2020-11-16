package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long bmk;

    public void setLiveId(long j) {
        this.bmk = j;
    }

    public long dYi() {
        return this.bmk;
    }

    public b() {
        super(1031042);
    }

    public void setParams() {
        addParam("live_id", this.bmk);
    }
}
