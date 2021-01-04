package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public int aas;
    public long hKC;
    public long igy;
    public long liveId;
    public int mWf;
    public int mWg;

    public a() {
        super(1031053);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.igy);
        addParam("refresh_type", this.aas);
        addParam("big_refresh_count", this.mWf);
        addParam("slide_session_id", this.hKC);
    }
}
