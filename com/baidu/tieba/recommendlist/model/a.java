package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public int aQN;
    public int aam;
    public long igz;
    public long liveId;
    public int nbq;
    public int nbr;
    public long nbs;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.igz);
        addParam("refresh_type", this.aam);
        addParam("big_refresh_count", this.nbq);
        addParam("live_recommend_switch", this.aQN);
        addParam("live_recommend_lastlyliveid", this.nbs);
    }
}
