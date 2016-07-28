package com.baidu.tieba.pb.data;

import tbclient.Lottery.DataRes;
/* loaded from: classes.dex */
public class e {
    private String dXR;
    private final LotteryUserChanceInfo dXS;
    private final d dXT;
    private int mStatus;

    private e(DataRes dataRes) {
        this.dXS = LotteryUserChanceInfo.createFromProtobuf(dataRes.chance);
        this.dXT = d.a(dataRes.award_info);
        this.mStatus = dataRes.status.intValue();
        this.dXR = dataRes.status_msg;
    }

    public d aGS() {
        return this.dXT;
    }

    public LotteryUserChanceInfo aGT() {
        return this.dXS;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getStatusMsg() {
        return this.dXR;
    }

    public static e a(DataRes dataRes) {
        return new e(dataRes);
    }
}
