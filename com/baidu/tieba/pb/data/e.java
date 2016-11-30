package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class e {
    private String erQ;
    private final LotteryUserChanceInfo erR;
    private final d erS;
    private int mStatus;

    private e(DataRes dataRes) {
        this.erR = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.erS = d.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.erQ = dataRes.status_msg;
    }

    public d aOf() {
        return this.erS;
    }

    public LotteryUserChanceInfo aOg() {
        return this.erR;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.erQ;
    }

    public static e a(DataRes dataRes) {
        return new e(dataRes);
    }
}
