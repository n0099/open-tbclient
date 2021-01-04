package com.baidu.tieba.yuyinala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class h extends HttpMessage {
    private long gVf;
    private long gVg;
    private String gVh;
    private String liveId;
    private String roomId;

    public h() {
        super(1031076);
    }

    public void fi(long j) {
        this.gVf = j;
    }

    public void fj(long j) {
        this.gVg = j;
    }

    public void Hp(String str) {
        this.gVh = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gVf);
        addParam("red_packet_num", this.gVg);
        addParam("condition", this.gVh);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
        addParam("is_jiaoyou", 1);
    }
}
