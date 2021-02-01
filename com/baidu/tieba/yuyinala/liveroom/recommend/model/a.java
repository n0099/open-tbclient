package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public int aam;
    public long hKi;
    public long igl;
    public long liveId;
    public int naQ;
    public int naR;

    public a() {
        super(1031053);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.igl);
        addParam("refresh_type", this.aam);
        addParam("big_refresh_count", this.naQ);
        addParam("slide_session_id", this.hKi);
    }
}
