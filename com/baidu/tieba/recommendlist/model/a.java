package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int YH;
    public int aPw;
    public long liveId;
    public long mwg;
    public int mwh;
    public int mwi;
    public long mwj;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.mwg);
        addParam("refresh_type", this.YH);
        addParam("big_refresh_count", this.mwh);
        addParam("live_recommend_switch", this.aPw);
        addParam("live_recommend_lastlyliveid", this.mwj);
    }
}
