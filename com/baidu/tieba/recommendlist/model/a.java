package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int YG;
    public long liveId;
    public long mjG;
    public int mjH;
    public int mjI;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.mjG);
        addParam("refresh_type", this.YG);
        addParam("big_refresh_count", this.mjH);
    }
}
