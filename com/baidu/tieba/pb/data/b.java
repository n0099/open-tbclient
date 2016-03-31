package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class b {
    private String dcC;
    private final LotteryUserChanceInfo dcD;
    private final a dcE;
    private int mStatus;

    private b(DataRes dataRes) {
        this.dcD = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.dcE = a.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.dcC = dataRes.status_msg;
    }

    public a avp() {
        return this.dcE;
    }

    public LotteryUserChanceInfo avq() {
        return this.dcD;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.dcC;
    }

    public static b a(DataRes dataRes) {
        return new b(dataRes);
    }
}
