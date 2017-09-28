package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class c {
    private String eyh;
    private final LotteryUserChanceInfo eyi;
    private final b eyj;
    private int mStatus;

    private c(DataRes dataRes) {
        this.eyi = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.eyj = b.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.eyh = dataRes.status_msg;
    }

    public b aMV() {
        return this.eyj;
    }

    public LotteryUserChanceInfo aMW() {
        return this.eyi;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.eyh;
    }

    public static c a(DataRes dataRes) {
        return new c(dataRes);
    }
}
