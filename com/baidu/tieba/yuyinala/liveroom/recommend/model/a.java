package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public int aaq;
    public long hFW;
    public long ibN;
    public long liveId;
    public int mRt;
    public int mRu;

    public a() {
        super(1031053);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.ibN);
        addParam("refresh_type", this.aaq);
        addParam("big_refresh_count", this.mRt);
        addParam("slide_session_id", this.hFW);
    }
}
