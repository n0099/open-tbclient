package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eid;
    private final LotteryUserChanceInfo eie;
    private final b eif;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eie = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eif = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eid = dataRes.status_msg;
    }

    public b aKs() {
        return this.eif;
    }

    public LotteryUserChanceInfo aKt() {
        return this.eie;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eid;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
