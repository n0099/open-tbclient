package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public int aNM;
    public int aaq;
    public long ibN;
    public long liveId;
    public int mRt;
    public int mRu;
    public long mRv;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.ibN);
        addParam("refresh_type", this.aaq);
        addParam("big_refresh_count", this.mRt);
        addParam("live_recommend_switch", this.aNM);
        addParam("live_recommend_lastlyliveid", this.mRv);
    }
}
