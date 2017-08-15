package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eFx;
    private final LotteryUserChanceInfo eFy;
    private final b eFz;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eFy = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eFz = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eFx = dataRes.status_msg;
    }

    public b aPJ() {
        return this.eFz;
    }

    public LotteryUserChanceInfo aPK() {
        return this.eFy;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eFx;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
