package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public int YM;
    public long hoY;
    public long liveId;
    public long mCB;
    public int mCC;
    public int mCD;

    public a() {
        super(1031053);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.mCB);
        addParam("refresh_type", this.YM);
        addParam("big_refresh_count", this.mCC);
        addParam("slide_session_id", this.hoY);
    }
}
