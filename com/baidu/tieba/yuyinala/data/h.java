package com.baidu.tieba.yuyinala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class h extends HttpMessage {
    private long guY;
    private long guZ;
    private String gva;
    private String liveId;
    private String roomId;

    public h() {
        super(1031076);
    }

    public void ei(long j) {
        this.guY = j;
    }

    public void ej(long j) {
        this.guZ = j;
    }

    public void GN(String str) {
        this.gva = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.guY);
        addParam("red_packet_num", this.guZ);
        addParam("condition", this.gva);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
        addParam("is_jiaoyou", 1);
    }
}
