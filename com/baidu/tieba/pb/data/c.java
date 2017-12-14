package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String ePh;
    private final LotteryUserChanceInfo ePi;
    private final b ePj;
    private int mStatus;

    private c(DataRes dataRes) {
        this.ePi = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.ePj = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.ePh = dataRes.status_msg;
    }

    public b aRk() {
        return this.ePj;
    }

    public LotteryUserChanceInfo aRl() {
        return this.ePi;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.ePh;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
