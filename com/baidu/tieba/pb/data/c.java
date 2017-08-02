package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eCq;
    private final LotteryUserChanceInfo eCr;
    private final b eCs;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eCr = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eCs = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eCq = dataRes.status_msg;
    }

    public b aOR() {
        return this.eCs;
    }

    public LotteryUserChanceInfo aOS() {
        return this.eCr;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eCq;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
