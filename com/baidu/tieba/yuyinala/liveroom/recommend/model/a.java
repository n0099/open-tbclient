package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public int abG;
    public long hMf;
    public long iii;
    public long liveId;
    public int ndu;
    public int ndv;

    public a() {
        super(1031053);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.iii);
        addParam("refresh_type", this.abG);
        addParam("big_refresh_count", this.ndu);
        addParam("slide_session_id", this.hMf);
    }
}
