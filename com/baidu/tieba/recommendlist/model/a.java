package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public int aSn;
    public int abG;
    public long iii;
    public long liveId;
    public int ndu;
    public int ndv;
    public long ndw;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.iii);
        addParam("refresh_type", this.abG);
        addParam("big_refresh_count", this.ndu);
        addParam("live_recommend_switch", this.aSn);
        addParam("live_recommend_lastlyliveid", this.ndw);
    }
}
