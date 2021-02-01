package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public int aQN;
    public int aam;
    public long igl;
    public long liveId;
    public int naQ;
    public int naR;
    public long naS;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.igl);
        addParam("refresh_type", this.aam);
        addParam("big_refresh_count", this.naQ);
        addParam("live_recommend_switch", this.aQN);
        addParam("live_recommend_lastlyliveid", this.naS);
    }
}
