package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public int aam;
    public long hKw;
    public long igz;
    public long liveId;
    public int nbq;
    public int nbr;

    public a() {
        super(1031053);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.igz);
        addParam("refresh_type", this.aam);
        addParam("big_refresh_count", this.nbq);
        addParam("slide_session_id", this.hKw);
    }
}
