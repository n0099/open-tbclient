package com.baidu.tieba.yuyinala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class h extends HttpMessage {
    private long gTx;
    private long gTy;
    private String gTz;
    private String liveId;
    private String roomId;

    public h() {
        super(1031076);
    }

    public void fo(long j) {
        this.gTx = j;
    }

    public void fp(long j) {
        this.gTy = j;
    }

    public void GD(String str) {
        this.gTz = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gTx);
        addParam("red_packet_num", this.gTy);
        addParam("condition", this.gTz);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
        addParam("is_jiaoyou", 1);
    }
}
