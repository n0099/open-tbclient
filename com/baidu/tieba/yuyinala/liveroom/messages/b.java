package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long brr;

    public void setLiveId(long j) {
        this.brr = j;
    }

    public long edM() {
        return this.brr;
    }

    public b() {
        super(1031042);
    }

    public void setParams() {
        addParam("live_id", this.brr);
    }
}
