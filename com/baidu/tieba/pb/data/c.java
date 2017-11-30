package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eOe;
    private final LotteryUserChanceInfo eOf;
    private final b eOg;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eOf = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eOg = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eOe = dataRes.status_msg;
    }

    public b aRb() {
        return this.eOg;
    }

    public LotteryUserChanceInfo aRc() {
        return this.eOf;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eOe;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
