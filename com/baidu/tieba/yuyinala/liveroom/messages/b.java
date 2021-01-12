package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    private long brk;

    public void setLiveId(long j) {
        this.brk = j;
    }

    public long dZn() {
        return this.brk;
    }

    public b() {
        super(1031042);
    }

    public void setParams() {
        addParam("live_id", this.brk);
    }
}
