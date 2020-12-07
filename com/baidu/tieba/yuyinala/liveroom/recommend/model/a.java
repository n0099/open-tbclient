package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int ZJ;
    public long hTW;
    public long hyC;
    public long liveId;
    public int mQD;
    public int mQE;

    public a() {
        super(1031053);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.hTW);
        addParam("refresh_type", this.ZJ);
        addParam("big_refresh_count", this.mQD);
        addParam("slide_session_id", this.hyC);
    }
}
