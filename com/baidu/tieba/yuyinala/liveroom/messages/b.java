package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    private long buN;

    public void setLiveId(long j) {
        this.buN = j;
    }

    public long ebH() {
        return this.buN;
    }

    public b() {
        super(1031042);
    }

    public void setParams() {
        addParam("live_id", this.buN);
    }
}
