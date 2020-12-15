package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int ZJ;
    public int aRK;
    public long hTY;
    public long liveId;
    public int mQF;
    public int mQG;
    public long mQH;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.hTY);
        addParam("refresh_type", this.ZJ);
        addParam("big_refresh_count", this.mQF);
        addParam("live_recommend_switch", this.aRK);
        addParam("live_recommend_lastlyliveid", this.mQH);
    }
}
