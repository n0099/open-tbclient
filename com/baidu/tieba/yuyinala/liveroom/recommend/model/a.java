package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int YH;
    public long hjA;
    public long liveId;
    public long mwg;
    public int mwh;
    public int mwi;

    public a() {
        super(1031053);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.mwg);
        addParam("refresh_type", this.YH);
        addParam("big_refresh_count", this.mwh);
        addParam("slide_session_id", this.hjA);
    }
}
