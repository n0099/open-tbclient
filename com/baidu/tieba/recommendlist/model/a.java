package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int ZJ;
    public int aRK;
    public long hTW;
    public long liveId;
    public int mQD;
    public int mQE;
    public long mQF;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.hTW);
        addParam("refresh_type", this.ZJ);
        addParam("big_refresh_count", this.mQD);
        addParam("live_recommend_switch", this.aRK);
        addParam("live_recommend_lastlyliveid", this.mQF);
    }
}
