package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int YM;
    public int aOI;
    public long liveId;
    public long mCB;
    public int mCC;
    public int mCD;
    public long mCE;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.mCB);
        addParam("refresh_type", this.YM);
        addParam("big_refresh_count", this.mCC);
        addParam("live_recommend_switch", this.aOI);
        addParam("live_recommend_lastlyliveid", this.mCE);
    }
}
