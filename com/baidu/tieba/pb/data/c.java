package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eik;
    private final LotteryUserChanceInfo eil;
    private final b eim;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eil = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eim = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eik = dataRes.status_msg;
    }

    public b aIu() {
        return this.eim;
    }

    public LotteryUserChanceInfo aIv() {
        return this.eil;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eik;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
