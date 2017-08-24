package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private final LotteryUserChanceInfo eFA;
    private final b eFB;
    private String eFz;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eFA = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eFB = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eFz = dataRes.status_msg;
    }

    public b aPE() {
        return this.eFB;
    }

    public LotteryUserChanceInfo aPF() {
        return this.eFA;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eFz;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
