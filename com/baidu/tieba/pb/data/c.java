package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String efl;
    private final LotteryUserChanceInfo efm;
    private final b efn;
    private int mStatus;

    private c(DataRes dataRes) {
        this.efm = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.efn = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.efl = dataRes.status_msg;
    }

    public b aJT() {
        return this.efn;
    }

    public LotteryUserChanceInfo aJU() {
        return this.efm;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.efl;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
