package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String efN;
    private final LotteryUserChanceInfo efO;
    private final b efP;
    private int mStatus;

    private c(DataRes dataRes) {
        this.efO = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.efP = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.efN = dataRes.status_msg;
    }

    public b aJr() {
        return this.efP;
    }

    public LotteryUserChanceInfo aJs() {
        return this.efO;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.efN;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
