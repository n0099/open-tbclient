package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    public int XV;
    public long lKS;
    public int lKT;
    public int lKU;
    public long liveId;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.lKS);
        addParam("refresh_type", this.XV);
        addParam("big_refresh_count", this.lKT);
    }
}
