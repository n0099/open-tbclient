package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String ePm;
    private final LotteryUserChanceInfo ePn;
    private final b ePo;
    private int mStatus;

    private c(DataRes dataRes) {
        this.ePn = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.ePo = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.ePm = dataRes.status_msg;
    }

    public b aRk() {
        return this.ePo;
    }

    public LotteryUserChanceInfo aRl() {
        return this.ePn;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.ePm;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
