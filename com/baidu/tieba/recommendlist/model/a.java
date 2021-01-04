package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public int aSz;
    public int aas;
    public long igy;
    public long liveId;
    public int mWf;
    public int mWg;
    public long mWh;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.igy);
        addParam("refresh_type", this.aas);
        addParam("big_refresh_count", this.mWf);
        addParam("live_recommend_switch", this.aSz);
        addParam("live_recommend_lastlyliveid", this.mWh);
    }
}
