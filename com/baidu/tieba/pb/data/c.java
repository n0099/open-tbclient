package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String ehG;
    private final LotteryUserChanceInfo ehH;
    private final b ehI;
    private int mStatus;

    private c(DataRes dataRes) {
        this.ehH = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.ehI = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.ehG = dataRes.status_msg;
    }

    public b aJk() {
        return this.ehI;
    }

    public LotteryUserChanceInfo aJl() {
        return this.ehH;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.ehG;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
