package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int Yq;
    public long lTZ;
    public int lUa;
    public int lUb;
    public long liveId;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.lTZ);
        addParam("refresh_type", this.Yq);
        addParam("big_refresh_count", this.lUa);
    }
}
