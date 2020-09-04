package com.baidu.tieba.recommendlist.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    public int XX;
    public long lLf;
    public int lLg;
    public int lLh;
    public long liveId;

    public a() {
        super(1021193);
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("session_id", this.lLf);
        addParam("refresh_type", this.XX);
        addParam("big_refresh_count", this.lLg);
    }
}
