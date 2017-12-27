package com.baidu.tieba.pb.data;

import java.io.Serializable;
import java.util.ArrayList;
import tbclient.Lottery.ActRegular;
import tbclient.Lottery.UserChance;
/* loaded from: classes2.dex */
public class LotteryUserChanceInfo implements Serializable {
    private final ArrayList<LotteryActRegularInfo> mActRegulars = new ArrayList<>();
    private long mChanceCount;
    private long mEnableGetChance;

    private LotteryUserChanceInfo(UserChance userChance) {
        if (userChance != null) {
            this.mChanceCount = userChance.chance_count.longValue();
            this.mEnableGetChance = userChance.enable_get_chance.longValue();
            for (ActRegular actRegular : userChance.regular) {
                if (actRegular != null) {
                    this.mActRegulars.add(LotteryActRegularInfo.createFromProtobuf(actRegular));
                }
            }
        }
    }

    public long getChanceCount() {
        return this.mChanceCount;
    }

    public long getEnableGetChance() {
        return this.mEnableGetChance;
    }

    public ArrayList<LotteryActRegularInfo> getActRegularList() {
        return this.mActRegulars;
    }

    public static LotteryUserChanceInfo createFromProtobuf(UserChance userChance) {
        return new LotteryUserChanceInfo(userChance);
    }
}
