package com.baidu.tieba.yuyinala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class h extends HttpMessage {
    private long gTj;
    private long gTk;
    private String gTl;
    private String liveId;
    private String roomId;

    public h() {
        super(1031076);
    }

    public void fo(long j) {
        this.gTj = j;
    }

    public void fp(long j) {
        this.gTk = j;
    }

    public void GC(String str) {
        this.gTl = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gTj);
        addParam("red_packet_num", this.gTk);
        addParam("condition", this.gTl);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
        addParam("is_jiaoyou", 1);
    }
}
