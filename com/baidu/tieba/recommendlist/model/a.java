package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int YH;
    public int aQt;
    public long liveId;
    public long mCd;
    public int mCe;
    public int mCf;
    public long mCg;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.mCd);
        addParam("refresh_type", this.YH);
        addParam("big_refresh_count", this.mCe);
        addParam("live_recommend_switch", this.aQt);
        addParam("live_recommend_lastlyliveid", this.mCg);
    }
}
